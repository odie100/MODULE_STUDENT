package com.akata.studentservice.services;

import com.akata.studentservice.dto.ContactRequestDTO;
import com.akata.studentservice.dto.ContactResponseDTO;
import com.akata.studentservice.entities.Contact;
import com.akata.studentservice.entities.Student;
import com.akata.studentservice.mapper.ContactMapper;
import com.akata.studentservice.mapper.StudentMapper;
import com.akata.studentservice.model.ContactModel;
import com.akata.studentservice.repository.ContactRepository;
import com.akata.studentservice.services.interfaces.ContactService;
import com.akata.studentservice.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    @Override
    public ContactResponseDTO save(ContactRequestDTO contactRequestDTO) {
        Contact contact = this.contactMapper.contactRequestDTOContact(contactRequestDTO);
        return this.contactMapper.contactToContactResponseDTO(this.contactRepository.save(contact));
    }

    @Override
    public ContactResponseDTO getContact(Long id) {
        return this.contactMapper.contactToContactResponseDTO(this.contactRepository.findById(id).get());
    }

    @Override
    public int update(Long id, ContactModel contactModel) {
        if(contactModel.getType().equals("email")){
            return this.contactRepository.updateEmail(contactModel.getValue(), id);
        }else{
            Contact checked_contact = this.contactRepository.findExisting("tel", id);
            if(checked_contact != null){
                return this.contactRepository.updateTel(contactModel.getValue(), id);
            }else{
                Student student = this.studentMapper.studentResponseDTOStudent(this.studentService.getStudent(id));
                Contact contact = new Contact(null, "tel", contactModel.getValue(), student);
                this.contactRepository.save(contact);
                return 1;
            }
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.contactRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<ContactResponseDTO> getAllContact() {
        List<Contact> contacts = this.contactRepository.findAll();
        return contacts.stream().map(contact -> this.contactMapper.contactToContactResponseDTO(contact))
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactResponseDTO> getContactByIdUser(Long id) {
        List<Contact> contacts = this.contactRepository.findAllByIdUser(id);
        return contacts.stream().map(contact -> this.contactMapper.contactToContactResponseDTO(contact))
                .collect(Collectors.toList());
    }

    @Override
    public ContactResponseDTO findByStudentAndType(String type, Long id_student) {
        return this.contactMapper.contactToContactResponseDTO(this.contactRepository.findExisting(type, id_student));
    }

    @Override
    public ContactResponseDTO getEmail(Long id) {
        return this.contactMapper.contactToContactResponseDTO(this.contactRepository.getEmail(id));
    }

    @Override
    public ContactResponseDTO getPhone(Long id) {
        ContactResponseDTO phone;
        try{
            phone = this.contactMapper.contactToContactResponseDTO(this.contactRepository.getPhone(id));
        }catch(DataAccessException e){
            System.out.println("Phone not found");
            phone = this.contactMapper.contactToContactResponseDTO(new Contact(null,"phone","",null));
        }
        return phone;
    }
}
