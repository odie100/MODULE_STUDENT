package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.ApplyRequestDTO;
import com.akata.studentservice.dto.ApplyResponseDTO;
import com.akata.studentservice.model.ApplyModel;
import com.akata.studentservice.model.ConfirmationModel;

import java.util.List;

public interface ApplyService {
    ApplyResponseDTO save(ApplyModel applyModel);

    ApplyResponseDTO getApply(Long id);

    ApplyResponseDTO update(Long id, ApplyRequestDTO applyRequestDTO);

    boolean delete(Long id);

    List<ApplyResponseDTO> getAllApplies();

    List<ApplyResponseDTO> getAllAppliesByIdStudent(Long id);

    int confirm(ConfirmationModel confirmationModel);

    List<ApplyResponseDTO> getAllAppliesByIdOffer(Long id);

    List<ApplyResponseDTO> getConfirmedApply(Long id);
}
