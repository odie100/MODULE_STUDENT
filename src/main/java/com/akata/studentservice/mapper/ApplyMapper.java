package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.ApplyRequestDTO;
import com.akata.studentservice.dto.ApplyResponseDTO;
import com.akata.studentservice.entities.Apply;
import com.akata.studentservice.model.ApplyModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplyMapper {
    ApplyResponseDTO applyToApplyResponseDTO(Apply apply);
    Apply applyRequestDTOApply (ApplyRequestDTO applyRequestDTO);
    Apply applyResponseDTOApply(ApplyResponseDTO applyResponseDTO);
    Apply applyModelTOApply(ApplyModel applyModel);
}
