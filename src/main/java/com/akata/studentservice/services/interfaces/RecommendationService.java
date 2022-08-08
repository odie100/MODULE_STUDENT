package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.RecommendationRequestDTO;
import com.akata.studentservice.dto.RecommendationResponseDTO;

import java.util.List;

public interface RecommendationService {
    RecommendationResponseDTO save(RecommendationRequestDTO recommendationRequestDTO);
    RecommendationResponseDTO getRecommendation(Long id);
    RecommendationResponseDTO update(Long id, RecommendationRequestDTO recommendationRequestDTO);
    boolean delete(Long id);
    List<RecommendationResponseDTO> getAllRecommendation();
}
