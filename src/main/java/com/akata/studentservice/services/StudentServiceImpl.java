package com.akata.studentservice.services;

import com.akata.studentservice.dto.*;
import com.akata.studentservice.entities.Student;
import com.akata.studentservice.mapper.LocationMapper;
import com.akata.studentservice.mapper.StudentMapper;
import com.akata.studentservice.model.ContactModel;
import com.akata.studentservice.model.RegistrationStudentModel;
import com.akata.studentservice.model.StudentModel;
import com.akata.studentservice.projections.StudentLightProjection;
import com.akata.studentservice.repository.StudentRepository;
import com.akata.studentservice.services.interfaces.ApplyService;
import com.akata.studentservice.services.interfaces.ContactService;
import com.akata.studentservice.services.interfaces.LocationService;
import com.akata.studentservice.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private ContactService contactService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private ApplyService applyService;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public StudentResponseDTO save(StudentRequestDTO studentRequestDTO) {
        studentRequestDTO.setCreation(LocalDate.now());
        Student saved_student = studentRepository.save(studentMapper.studentRequestDTOStudent(studentRequestDTO));
        return studentMapper.studentToStudentResponseDTO(saved_student);
    }

    @Override
    public StudentResponseDTO getStudent(Long id) {
        Student student = studentRepository.findById(id).get();
        StudentResponseDTO studentResponseDTO = this.studentMapper.studentToStudentResponseDTO(student);
        studentResponseDTO.setEmail(this.contactService.getEmail(student.getId()).getValue());
        studentResponseDTO.setPhone(this.contactService.getPhone(student.getId()).getValue());
        System.out.println(student);
        return studentResponseDTO;
    }

    @Override
    public int update(Long id, StudentModel sm) {

        Student student = this.studentRepository.findById(id).get();

        ContactModel email_model = new ContactModel("email", sm.getEmail());
        ContactModel tel_model = new ContactModel("tel", sm.getTel());

        LocationRequestDTO locationRequestDTO = new LocationRequestDTO(sm.getCountry(), sm.getAddress(), sm.getTown());
        this.locationService.update(student.getLocation().getId(), locationRequestDTO);

        this.contactService.update(id, email_model);
        this.contactService.update(id, tel_model);

        return this.studentRepository.update(sm.getUsername(), sm.getFirstname(), sm.getSchool(), sm.getLevel(),
                sm.getSchool_career(), sm.getBio(), sm.getPhoto(), id);
    }

    @Override
    public int updateCV(String cv_name, Long id) {
        return this.studentRepository.updateCV(cv_name, id);
    }

    @Override
    public boolean delete(Long id) {
        try {
            studentRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDTO> studentResponseDTOS = students.stream().map(student -> this.studentMapper
                .studentToStudentResponseDTO(student)).collect(Collectors.toList());

        for(StudentResponseDTO studentResponseDTO: studentResponseDTOS){
            System.out.println(studentResponseDTO);
            studentResponseDTO.setAverage(this.ratingService.average(studentResponseDTO.getId()));
            studentResponseDTO.setEmail(this.contactService.getEmail(studentResponseDTO.getId()).getValue());
            studentResponseDTO.setPhone(this.contactService.getPhone(studentResponseDTO.getId()).getValue());
            studentResponseDTO.setProject_finished(this.applyService.countProjectFinished(studentResponseDTO.getId()));
            studentResponseDTO.setProject_on_progress(this.applyService.countProjectOnProgress(studentResponseDTO.getId()));
        }

        return studentResponseDTOS;
    }

    @Override
    public StudentLightProjection signIn(String email, String password) {
        Long id;
        try {
            id = this.studentRepository.login(email, password);
            System.out.println("here is the id: "+id);
        }catch (DataAccessException e){
            throw new RuntimeException("User not found");
        }
        StudentLightProjection studentLightProjection = new StudentLightProjection();
        if(id != null){
            studentLightProjection.setId(id);
            studentLightProjection.setType("student");
        }
        System.out.println("Projection returned: "+studentLightProjection.toString());
        return studentLightProjection;
    }

    @Override
    public StudentResponseDTO register(RegistrationStudentModel registrationStudentModel) {
        //Step 1:
        LocationRequestDTO locationRequestDTO = new LocationRequestDTO();
        locationRequestDTO.setAddress(registrationStudentModel.getAddress());
        locationRequestDTO.setCountry(registrationStudentModel.getCountry());
        locationRequestDTO.setTown(registrationStudentModel.getTown());
        LocationResponseDTO locationResponseDTO = this.locationService.save(locationRequestDTO);
        //Step 2:
        StudentRequestDTO studentRequestDTO = new StudentRequestDTO();
        studentRequestDTO.setLocation(this.locationMapper.locationResponseToLocation(locationResponseDTO));
        studentRequestDTO.setPassword(registrationStudentModel.getPassword());
        studentRequestDTO.setUsername(registrationStudentModel.getUsername());
        studentRequestDTO.setFirstname(registrationStudentModel.getFirstname());
        studentRequestDTO.setLevel(registrationStudentModel.getLevel());
        studentRequestDTO.setSchool(registrationStudentModel.getSchool());
        studentRequestDTO.setSchool_career(registrationStudentModel.getSchool_career());
        studentRequestDTO.setBio(registrationStudentModel.getBio());
        studentRequestDTO.setCurrent_position(registrationStudentModel.getCurrent_position());
        StudentResponseDTO student_saved = save(studentRequestDTO);
        //last Step:
        if(!registrationStudentModel.getEmail().isEmpty()){
            ContactRequestDTO email_contact = new ContactRequestDTO();
            email_contact.setType("email");
            email_contact.setValue(registrationStudentModel.getEmail());
            email_contact.setStudent(this.studentMapper.studentResponseDTOStudent(student_saved));
            this.contactService.save(email_contact);
        }

        if(!registrationStudentModel.getTel().isEmpty()){
            ContactRequestDTO tel_contact = new ContactRequestDTO();
            tel_contact.setType("tel");
            tel_contact.setValue(registrationStudentModel.getTel());
            tel_contact.setStudent(this.studentMapper.studentResponseDTOStudent(student_saved));
            this.contactService.save(tel_contact);
        }

        return student_saved;
    }

    @Override
    public String uploadPhoto(MultipartFile file) throws IOException {
        return this.fileStorageService.saveImage(file);
    }

    @Override
    public String uploadDocument(MultipartFile file) throws IOException {
        return this.fileStorageService.saveDocument(file);
    }

    @Override
    public String uploadVideo(MultipartFile video) throws IOException {
        return this.fileStorageService.saveVideo(video);
    }

}
