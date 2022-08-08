package com.akata.studentservice.services;

import com.akata.studentservice.dto.RecommendationRequestDTO;
import com.akata.studentservice.dto.RecommendationResponseDTO;
import com.akata.studentservice.dto.SRecommendationRequestDTO;
import com.akata.studentservice.dto.SRecommendationResponseDTO;
import com.akata.studentservice.entities.Student;
import com.akata.studentservice.entities.StudentRecommendation;
import com.akata.studentservice.mapper.RecommendationMapper;
import com.akata.studentservice.mapper.SRecommendationMapper;
import com.akata.studentservice.mapper.StudentMapper;
import com.akata.studentservice.model.RecommendationModel;
import com.akata.studentservice.repository.StudentRecommendationRepository;
import com.akata.studentservice.services.interfaces.RecommendationService;
import com.akata.studentservice.services.interfaces.SRecommendationService;
import com.akata.studentservice.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SRecommendationServiceImpl implements SRecommendationService {
    @Autowired
    private StudentRecommendationRepository studentRecommendationRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private RecommendationMapper recommendationMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SRecommendationMapper sRecommendationMapper;

    @Override
    public SRecommendationResponseDTO save(RecommendationModel recommendationModel) {

        RecommendationRequestDTO recommendation = new RecommendationRequestDTO();
        recommendation.setRecommendation(recommendationModel.getRecommendation());

        RecommendationResponseDTO saved_recommendation = this.recommendationService.save(recommendation);

        StudentRecommendation studentRecommendation = new StudentRecommendation();

        Student student = this.studentMapper.studentResponseDTOStudent(
                this.studentService.getStudent(recommendationModel.getId_student())
        );

     /*   Recommendation recom = this.recommendationMapper.recomResponseToRecom(
                this.recommendationService.getRecommendation(saved_recommendation.getId())
        );*/

        studentRecommendation.setStudent(student);
        studentRecommendation.setRecommendation(this.recommendationMapper.recomResponseToRecom(saved_recommendation));

        return this.sRecommendationMapper.srecommendationToSRecommendationResponseDTO(
                this.studentRecommendationRepository.save(studentRecommendation)
        );
    }

    @Override
    public SRecommendationResponseDTO getSRecommendation(Long id) {
        return this.sRecommendationMapper.srecommendationToSRecommendationResponseDTO(
                this.studentRecommendationRepository.findById(id).get()
        );
    }

    @Override
    public SRecommendationResponseDTO update(Long id, SRecommendationRequestDTO sRecommendationRequestDTO) {
        StudentRecommendation studentRecommendation = this.sRecommendationMapper
                .recommendationRequestDTORecommendation(sRecommendationRequestDTO);
        studentRecommendation.setId(id);
        return this.sRecommendationMapper.srecommendationToSRecommendationResponseDTO(
                this.studentRecommendationRepository.save(studentRecommendation)
        );
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.studentRecommendationRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<SRecommendationResponseDTO> getAllSRecommendation() {
        List<StudentRecommendation> studentRecommendations  = this.studentRecommendationRepository.findAll();
        return studentRecommendations.stream().map(studentRecommendation -> this.sRecommendationMapper
                .srecommendationToSRecommendationResponseDTO(studentRecommendation)).collect(Collectors.toList());
    }
}
