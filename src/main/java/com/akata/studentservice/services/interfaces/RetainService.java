package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.RetainResponseDTO;
import com.akata.studentservice.model.RetainModel;

import java.util.List;

public interface RetainService {
    RetainResponseDTO save (RetainModel retainModel);
    List<RetainResponseDTO> getAll();
    List<RetainResponseDTO> getAllById(Long id);
    RetainResponseDTO deleteByIdStudent(Long id_student);
}
