package com.akata.studentservice.services;

import com.akata.studentservice.dto.ExperienceRequestDTO;
import com.akata.studentservice.dto.ExperienceResponseDTO;
import com.akata.studentservice.entities.Experience;
import com.akata.studentservice.mapper.ExperienceMapper;
import com.akata.studentservice.repository.ExperienceRepository;
import com.akata.studentservice.services.interfaces.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ExperienceMapper experienceMapper;

    @Override
    public ExperienceResponseDTO save(ExperienceRequestDTO experienceRequestDTO) {
        Experience experience = this.experienceMapper.experienceRequestDTOExperience(experienceRequestDTO);
        return this.experienceMapper.experienceToExperienceResponseDTO(this.experienceRepository.save(experience));
    }

    @Override
    public ExperienceResponseDTO get(Long id) {
        return this.experienceMapper.experienceToExperienceResponseDTO(this.experienceRepository.findById(id).get());
    }

    @Override
    public ExperienceResponseDTO update(Long id, ExperienceRequestDTO experienceRequestDTO) {
        Experience experience = this.experienceMapper.experienceRequestDTOExperience(experienceRequestDTO);
        experience.setId(id);
        return this.experienceMapper.experienceToExperienceResponseDTO(this.experienceRepository.save(experience));
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.experienceRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<ExperienceResponseDTO> getAllExperiences() {
        List<Experience> experiences = this.experienceRepository.findAll();
        return experiences.stream().map((experience -> this.experienceMapper.experienceToExperienceResponseDTO(
                experience
        ))).collect(Collectors.toList());
    }
}
