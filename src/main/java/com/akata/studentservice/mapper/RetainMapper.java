package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.RetainRequestDTO;
import com.akata.studentservice.dto.RetainResponseDTO;
import com.akata.studentservice.entities.Retain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RetainMapper {
    RetainResponseDTO retainToResponse (Retain retain);
    Retain requestToRetain(RetainRequestDTO retainRequestDTO);
    Retain responseToRetain(RetainResponseDTO retainResponseDTO);
}
