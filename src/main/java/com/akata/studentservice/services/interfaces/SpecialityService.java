package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.SpecialityRequestDTO;
import com.akata.studentservice.dto.SpecialityResponseDTO;

import java.util.List;

public interface SpecialityService {

    List<SpecialityResponseDTO> getAll();
    SpecialityResponseDTO add(SpecialityRequestDTO specialityRequestDTO);

    SpecialityResponseDTO getById(Long id);
}
