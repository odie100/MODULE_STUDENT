package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.ExperienceRequestDTO;
import com.akata.studentservice.dto.ExperienceResponseDTO;

import java.util.List;

public interface ExperienceService {
    ExperienceResponseDTO save(ExperienceRequestDTO experienceRequestDTO);
    ExperienceResponseDTO get(Long id);
    ExperienceResponseDTO update(Long id, ExperienceRequestDTO experienceRequestDTO);
    boolean delete(Long id);
    List<ExperienceResponseDTO> getAllExperiences();
}
