package com.akata.studentservice.services;

import com.akata.studentservice.dto.*;
import com.akata.studentservice.entities.Apply;
import com.akata.studentservice.entities.Student;
import com.akata.studentservice.mapper.ApplyMapper;
import com.akata.studentservice.mapper.StudentMapper;
import com.akata.studentservice.model.ApplyModel;
import com.akata.studentservice.model.Client;
import com.akata.studentservice.model.ConfirmationModel;
import com.akata.studentservice.model.EmailModel;
import com.akata.studentservice.openfeign.ApplyRestClient;
import com.akata.studentservice.openfeign.ApplyRestOffer;
import com.akata.studentservice.repository.ApplyRepository;
import com.akata.studentservice.services.interfaces.ApplyService;
import com.akata.studentservice.services.interfaces.ContactService;
import com.akata.studentservice.services.interfaces.EmailService;
import com.akata.studentservice.services.interfaces.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyRepository applyRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ApplyMapper applyMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ApplyRestOffer applyRestOffer;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ApplyRestClient applyRestClient;

    @Autowired
    private ContactService contactService;

    @Autowired
    private final JavaMailSender emailSender;
    @Autowired
    private final SpringTemplateEngine templateEngine;

    public ApplyServiceImpl(JavaMailSender emailSender, SpringTemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public ApplyResponseDTO save(ApplyModel applyModel) {
        Apply apply = this.applyMapper.applyModelTOApply(applyModel);
        Student student = this.studentMapper.studentResponseDTOStudent(this.studentService.getStudent(applyModel.getId_student()));
        /*Need to get Offer via different service*/
        OfferResponseDTO offer = this.applyRestOffer.getOffer(applyModel.getId_offer());
        apply.setApply_date(LocalDate.now());
        apply.setOffer_id(offer.getOffer_id());
        apply.setStatus("in progress");
        apply.setPrice(applyModel.getPrice());
        apply.setMessage(applyModel.getMessage());
        apply.setStudent(student);

        Apply saved_apply = this.applyRepository.save(apply);
        saved_apply.setOffer(offer);

        return this.applyMapper.applyToApplyResponseDTO(saved_apply);
    }

    @Override
    public ApplyResponseDTO getApply(Long id) {
        return this.applyMapper.applyToApplyResponseDTO(this.applyRepository.findById(id).get());
    }

    @Override
    public ApplyResponseDTO update(Long id, ApplyRequestDTO applyRequestDTO) {
        Apply apply = this.applyMapper.applyRequestDTOApply(applyRequestDTO);
        apply.setId(id);
        return this.applyMapper.applyToApplyResponseDTO(this.applyRepository.save(apply));
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.applyRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<ApplyResponseDTO> getAllApplies() {
        List<Apply> applies = this.applyRepository.findAll();
        //Injecting the offer information
        for (Apply apply: applies){
            OfferResponseDTO offerResponseDTO = this.applyRestOffer.getOffer(apply.getOffer_id());
            apply.setOffer(offerResponseDTO);
        }

        return applies.stream().map(apply -> this.applyMapper.applyToApplyResponseDTO(apply))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplyResponseDTO> getAllAppliesByIdStudent(Long id) {
        List<Apply> applies = this.applyRepository.getApplyByIdStudent(id);
        //Injecting the offer information
        for (Apply apply:applies){
            OfferResponseDTO offerResponseDTO = this.applyRestOffer.getOffer(apply.getOffer_id());
            apply.setOffer(offerResponseDTO);
        }
        return applies.stream().map(apply -> this.applyMapper.applyToApplyResponseDTO(apply))
                .collect(Collectors.toList());
    }

    @Override
    public int confirm(ConfirmationModel confirmationModel) throws MessagingException {
        this.applyRepository.update(confirmationModel.getId_apply());

        ContactResponseDTO contactResponseDTO = this.applyRestClient.getContact(confirmationModel.getId_client());
        ContactResponseDTO contactResponseDTO1 = this.contactService.findByStudentAndType("email", confirmationModel.getId_student());
        String from = contactResponseDTO.getValue();
        String subject = "Retour suit au postulation";
        String to = contactResponseDTO1.getValue();
        String content = "";
        /*EmailModel emailModel = new EmailModel(to, from, subject,content,"",);*/
/*        if(state == 1){
            this.emailService.send(emailModel);
            return 1;
        }else{
            return -1;
        }*/

        EmailModel email = new EmailModel();
        email.setFrom(from);
        email.setText(content);
        email.setTo(to);
        email.setSubject(subject);
        email.setProperties(null);
        email.setTemplate("");
        email.setClient_name(confirmationModel.getClient_name());
        email.setStudent_name(confirmationModel.getStudent_name());



        String msg = "Félicitation "+email.getStudent_name()+"! Vous êtes selectionné parmis les candidats qui ont "+
                "postulé à l'offre de "+email.getClient_name();

        Map<String, Object> properties = new HashMap<>();

        properties.put("name",email.getStudent_name());
        properties.put("client", email.getClient_name());
        properties.put("message",msg);
        email.setProperties(properties);
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Context context = new Context();
        context.setVariables(email.getProperties());
        helper.setFrom(email.getFrom());
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        String html = templateEngine.process("email-template.html", context);
        helper.setText(html, true);

        log.info("Sending email: {} with html body: {}", email, html);

        try {
            emailSender.send(message);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<ApplyResponseDTO> getAllAppliesByIdOffer(Long id) {
        List<Apply> applies = this.applyRepository.getApplyByIdOffer(id);
        for(Apply apply: applies){
            OfferResponseDTO offerResponseDTO = this.applyRestOffer.getOffer(id);
            apply.setOffer(offerResponseDTO);
        }
        return applies.stream().map(apply -> this.applyMapper.applyToApplyResponseDTO(apply)).collect(Collectors.toList());
    }

    @Override
    public List<ApplyResponseDTO> getConfirmedApply(Long id) {
        List<Apply> applies = this.applyRepository.getApplyConfirmed(id);
        return applies.stream().map(apply -> this.applyMapper.applyToApplyResponseDTO(apply)).collect(Collectors.toList());
    }

    @Override
    public int countProjectOnProgress(Long id) {
        return this.applyRepository.countProjectOnProgress(id);
    }

    @Override
    public int countProjectFinished(Long id) {
        return this.applyRepository.countProjectFinished(id);
    }
}
