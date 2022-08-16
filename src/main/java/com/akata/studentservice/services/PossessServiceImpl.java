package com.akata.studentservice.services;

import com.akata.studentservice.dto.PossessRequestDTO;
import com.akata.studentservice.dto.PossessResponseDTO;
import com.akata.studentservice.entities.Possess;
import com.akata.studentservice.mapper.PossessMapper;
import com.akata.studentservice.repository.PossessRepository;
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
    public PossessResponseDTO update(Long id, PossessRequestDTO possessRequestDTO) {
        Possess possess = this.possessMapper.requestToPossess(possessRequestDTO);
        possess.setId(id);
        return this.possessMapper.possessToResponse(this.possessRepository.save(possess));
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
