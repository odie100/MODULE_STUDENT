package com.akata.studentservice.services;

import com.akata.studentservice.dto.ContactRequestDTO;
import com.akata.studentservice.dto.ContactResponseDTO;
import com.akata.studentservice.entities.Contact;
import com.akata.studentservice.mapper.ContactMapper;
import com.akata.studentservice.repository.ContactRepository;
import com.akata.studentservice.services.interfaces.ContactService;
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
    public ContactResponseDTO update(Long id, ContactRequestDTO contactRequestDTO) {
        Contact contact = this.contactMapper.contactRequestDTOContact(contactRequestDTO);
        contact.setId(id);
        return this.contactMapper.contactToContactResponseDTO(this.contactRepository.save(contact));
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
}
