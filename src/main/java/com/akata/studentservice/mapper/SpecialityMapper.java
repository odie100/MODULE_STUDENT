package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.SpecialityRequestDTO;
import com.akata.studentservice.dto.SpecialityResponseDTO;
import com.akata.studentservice.entities.Speciality;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    SpecialityResponseDTO specialityToSpecialityResponseDTO(Speciality speciality);
    Speciality specialityRequestDTOSpeciality(SpecialityRequestDTO specialityRequestDTO);
    Speciality specialityResponseDTOSpeciality(SpecialityResponseDTO specialityResponseDTO);
    SpecialityResponseDTO specialityRequestToResponse(SpecialityRequestDTO specialityRequestDTO);
}
