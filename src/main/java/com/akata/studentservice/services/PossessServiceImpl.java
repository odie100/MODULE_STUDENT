package com.akata.studentservice.services;

import com.akata.studentservice.dto.PossessRequestDTO;
import com.akata.studentservice.dto.PossessResponseDTO;
import com.akata.studentservice.entities.Experience;
import com.akata.studentservice.entities.Possess;
import com.akata.studentservice.mapper.PossessMapper;
import com.akata.studentservice.model.ExperienceModel;
import com.akata.studentservice.repository.ExperienceRepository;
import com.akata.studentservice.repository.PossessRepository;
import com.akata.studentservice.repository.StudentRepository;
import com.akata.studentservice.services.interfaces.PossessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PossessServiceImpl implements PossessService {

    @Autowired
    private PossessRepository possessRepository;

    @Autowired
    private PossessMapper possessMapper;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public PossessResponseDTO save(PossessRequestDTO possessRequestDTO) {
        Possess possess = this.possessMapper.requestToPossess(possessRequestDTO);
        return this.possessMapper.possessToResponse(this.possessRepository.save(possess));
    }

    @Override
    public PossessResponseDTO get(Long id) {
        return this.possessMapper.possessToResponse(this.possessRepository.findById(id).get());
    }

    @Override
    public PossessResponseDTO update(Long id, ExperienceModel experienceModel) {
        Long xp_id = -1L;
        Possess possess = new Possess();
        Experience experience = new Experience();

        try {
            Possess possess_tmp = this.possessRepository.getByStudent(id);
            xp_id = possess_tmp != null ? possess_tmp.getExperience().getId() : -1L;
        }catch (DataAccessException e){
            e.printStackTrace();
        }

        if(xp_id == -1L){
            System.out.println("No possess found ");
            experience.setId(null);
            experience.setDetails(experienceModel.getDetails());
            Experience saved_xp = this.experienceRepository.save(experience);
            possess.setExperience(saved_xp);
            possess.setStudent(this.studentRepository.findById(id).get());
            this.possessRepository.save(possess);
        }else{
            System.out.println("Possess found");
            System.out.println("trye 1, xp_id ;"+xp_id);
            possess.setStudent(this.studentRepository.findById(id).get());
            System.out.println("trye 2");
            possess.setExperience(this.experienceRepository.findById(xp_id).get());
            System.out.println("trye 3");
            this.experienceRepository.update(experienceModel.getDetails(), xp_id);
        }

        return this.possessMapper.possessToResponse(possess);
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.possessRepository.deleteById(id);
            return true;
        }catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public List<PossessResponseDTO> getAllPossesses() {
        List<Possess> possesses = this.possessRepository.findAll();
        return possesses.stream().map((possess -> this.possessMapper.possessToResponse(possess)))
                .collect(Collectors.toList());
    }

    @Override
    public List<PossessResponseDTO> getAllPossessesByIdStudent(Long id) {
        List<Possess> possesses = this.possessRepository.getAllByIdStudent(id);
        return possesses.stream().map(possess -> this.possessMapper.possessToResponse(possess))
                .collect(Collectors.toList());
    }
}
