package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.RecommendationRequestDTO;
import com.akata.studentservice.dto.RecommendationResponseDTO;
import com.akata.studentservice.entities.Recommendation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    RecommendationResponseDTO recommendationToRecommendationResponseDTO(Recommendation recommendation);
    Recommendation recommendationRequestDTORecommendation (RecommendationRequestDTO recommendationRequestDTO);
    Recommendation recomResponseToRecom(RecommendationResponseDTO recommendationResponseDTO);
}
