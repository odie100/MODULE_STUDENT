package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.PossessRequestDTO;
import com.akata.studentservice.dto.PossessResponseDTO;
import com.akata.studentservice.entities.Possess;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PossessMapper {
    PossessResponseDTO possessToResponse (Possess possess);
    Possess requestToPossess(PossessRequestDTO possessRequestDTO);
    Possess responseToPossess(PossessResponseDTO possessResponseDTO);
}
