package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.SRecommendationRequestDTO;
import com.akata.studentservice.dto.SRecommendationResponseDTO;
import com.akata.studentservice.model.RecommendationModel;
import com.akata.studentservice.services.interfaces.RecommendationService;
import com.akata.studentservice.services.interfaces.SRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student_recommendation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentRecommendationController {
    @Autowired
    private SRecommendationService studentRecommendationService;

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping(path = "/all")
    public List<SRecommendationResponseDTO> getAll(){
        return this.studentRecommendationService.getAllSRecommendation();
    }

    @GetMapping(path = "/{id}")
    public SRecommendationResponseDTO get(@PathVariable("id") Long id){
        return this.studentRecommendationService.getSRecommendation(id);
    }

    @PostMapping(path = "/insert")
    public SRecommendationResponseDTO insert(@RequestBody RecommendationModel recommendationModel){
        return this.studentRecommendationService.save(recommendationModel);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.studentRecommendationService.delete(id);
    }

    @PutMapping(path = "{id}")
    public SRecommendationResponseDTO update(@PathVariable("id") Long id, @RequestBody SRecommendationRequestDTO studentRecommendation){
        return this.studentRecommendationService.update(id, studentRecommendation);
    }
}
