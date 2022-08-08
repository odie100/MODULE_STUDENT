package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.SRecommendationRequestDTO;
import com.akata.studentservice.dto.SRecommendationResponseDTO;
import com.akata.studentservice.model.RecommendationModel;

import java.util.List;

public interface SRecommendationService {
    SRecommendationResponseDTO save(RecommendationModel recommendationModel);

    SRecommendationResponseDTO getSRecommendation(Long id);

    SRecommendationResponseDTO update(Long id, SRecommendationRequestDTO sRecommendationRequestDTO);

    boolean delete(Long id);

    List<SRecommendationResponseDTO> getAllSRecommendation();
}
