package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.ExperienceRequestDTO;
import com.akata.studentservice.dto.ExperienceResponseDTO;
import com.akata.studentservice.entities.Experience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {
    ExperienceResponseDTO experienceToExperienceResponseDTO(Experience experience);
    Experience experienceRequestDTOExperience (ExperienceRequestDTO experienceRequestDTO);
}
