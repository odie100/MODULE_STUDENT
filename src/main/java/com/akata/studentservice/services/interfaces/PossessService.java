package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.PossessRequestDTO;
import com.akata.studentservice.dto.PossessResponseDTO;

import java.util.List;

public interface PossessService {
    PossessResponseDTO save(PossessRequestDTO possessRequestDTO);
    PossessResponseDTO get(Long id);
    PossessResponseDTO update(Long id, PossessRequestDTO possessRequestDTO);
    boolean delete(Long id);
    List<PossessResponseDTO> getAllPossesses();
    List<PossessResponseDTO> getAllPossessesByIdStudent(Long id);
}
