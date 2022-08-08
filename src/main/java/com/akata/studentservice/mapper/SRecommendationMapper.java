package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.SRecommendationRequestDTO;
import com.akata.studentservice.dto.SRecommendationResponseDTO;
import com.akata.studentservice.entities.StudentRecommendation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SRecommendationMapper {
    SRecommendationResponseDTO srecommendationToSRecommendationResponseDTO(StudentRecommendation recommendation);
    StudentRecommendation recommendationRequestDTORecommendation (SRecommendationRequestDTO recommendationRequestDTO);
}
