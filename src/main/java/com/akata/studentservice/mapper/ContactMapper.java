package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.ContactRequestDTO;
import com.akata.studentservice.dto.ContactResponseDTO;
import com.akata.studentservice.entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactResponseDTO contactToContactResponseDTO(Contact contact);
    Contact contactRequestDTOContact (ContactRequestDTO contactRequestDTO);
}
