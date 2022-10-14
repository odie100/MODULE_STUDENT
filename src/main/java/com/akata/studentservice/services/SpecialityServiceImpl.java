package com.akata.studentservice.services;

import com.akata.studentservice.dto.SpecialityRequestDTO;
import com.akata.studentservice.dto.SpecialityResponseDTO;
import com.akata.studentservice.entities.Speciality;
import com.akata.studentservice.mapper.SpecialityMapper;
import com.akata.studentservice.repository.SpecialityRepository;
import com.akata.studentservice.services.interfaces.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    private SpecialityMapper specialityMapper;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public List<SpecialityResponseDTO> getAll() {
        List<Speciality> specialities = this.specialityRepository.findAll();
        return specialities.stream().map((speciality) -> this.specialityMapper.specialityToSpecialityResponseDTO(
                speciality
        )).collect(Collectors.toList());
    }

    @Override
    public SpecialityResponseDTO add(SpecialityRequestDTO specialityRequestDTO) {
        List<Speciality> specialities = this.specialityRepository.findAll();
        Speciality speciality = this.specialityMapper.specialityRequestDTOSpeciality(specialityRequestDTO);
        if(specialities.contains(speciality)) {
            return this.specialityMapper.specialityRequestToResponse(specialityRequestDTO);
        }else{
            return this.specialityMapper.specialityToSpecialityResponseDTO(
                    this.specialityRepository.save(this.specialityMapper
                            .specialityRequestDTOSpeciality(specialityRequestDTO)));
        }
    }

    @Override
    public SpecialityResponseDTO getById(Long id) {
        return this.specialityMapper.specialityToSpecialityResponseDTO(
                this.specialityRepository.findById(id).get()
        );
    }
}
