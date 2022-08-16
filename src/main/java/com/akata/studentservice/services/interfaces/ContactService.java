package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.ContactRequestDTO;
import com.akata.studentservice.dto.ContactResponseDTO;
import com.akata.studentservice.model.ContactModel;

import java.util.List;

public interface ContactService {
    ContactResponseDTO save(ContactRequestDTO contactRequestDTO);

    ContactResponseDTO getContact(Long id);

    int update(Long id, ContactModel contactModel);

    boolean delete(Long id);

    List<ContactResponseDTO> getAllContact();

    List<ContactResponseDTO> getContactByIdUser(Long id);
}
