package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.ContactRequestDTO;
import com.akata.studentservice.dto.ContactResponseDTO;

import java.util.List;

public interface ContactService {
    ContactResponseDTO save(ContactRequestDTO contactRequestDTO);

    ContactResponseDTO getContact(Long id);

    ContactResponseDTO update(Long id, ContactRequestDTO contactRequestDTO);

    boolean delete(Long id);

    List<ContactResponseDTO> getAllContact();

    List<ContactResponseDTO> getContactByIdUser(Long id);
}
