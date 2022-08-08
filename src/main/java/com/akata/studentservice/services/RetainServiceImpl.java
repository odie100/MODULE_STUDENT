package com.akata.studentservice.services;

import com.akata.studentservice.dto.RetainRequestDTO;
import com.akata.studentservice.dto.RetainResponseDTO;
import com.akata.studentservice.entities.Retain;
import com.akata.studentservice.entities.Speciality;
import com.akata.studentservice.entities.Student;
import com.akata.studentservice.mapper.RetainMapper;
import com.akata.studentservice.mapper.SpecialityMapper;
import com.akata.studentservice.mapper.StudentMapper;
import com.akata.studentservice.model.RetainModel;
import com.akata.studentservice.repository.RetainRepository;
import com.akata.studentservice.services.interfaces.RetainService;
import com.akata.studentservice.services.interfaces.SpecialityService;
import com.akata.studentservice.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetainServiceImpl implements RetainService {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private SpecialityMapper specialityMapper;

    @Autowired
    private RetainMapper retainMapper;

    @Autowired
    private RetainRepository retainRepository;

    @Override
    public RetainResponseDTO save(RetainModel retainModel) {
        Student student = this.studentMapper.studentResponseDTOStudent(
                this.studentService.getStudent(retainModel.getId_student())
        );

        Speciality speciality = this.specialityMapper.specialityResponseDTOSpeciality(
                this.specialityService.getById(retainModel.getId_speciality())
        );

        RetainRequestDTO retainRequestDTO = new RetainRequestDTO();
        retainRequestDTO.setSpeciality(speciality);
        retainRequestDTO.setStudent(student);

        return this.retainMapper.retainToResponse(
                this.retainRepository.save(this.retainMapper.requestToRetain(retainRequestDTO))
        );
    }

    @Override
    public List<RetainResponseDTO> getAll() {
        List<Retain> retains = this.retainRepository.findAll();
        return retains.stream().map(retain -> this.retainMapper.retainToResponse(retain)).collect(Collectors.toList());
    }

    @Override
    public List<RetainResponseDTO> getAllById(Long id) {
        List<Retain> retains = this.retainRepository.findByIdStudent(id);
        return retains.stream().map(retain -> this.retainMapper.retainToResponse(retain)).collect(Collectors.toList());
    }

    @Override
    public RetainResponseDTO deleteByIdStudent(Long id_student) {
        return  this.retainMapper.retainToResponse(this.retainRepository.deleteByIdStudent(id_student));
    }
}
