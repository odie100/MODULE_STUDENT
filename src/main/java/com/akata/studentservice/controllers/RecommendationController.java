package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.RecommendationRequestDTO;
import com.akata.studentservice.dto.RecommendationResponseDTO;
import com.akata.studentservice.services.interfaces.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rating")
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @PostMapping(path = "/insert")
    public RecommendationResponseDTO insert(@RequestBody RecommendationRequestDTO recommendationRequestDTO){
        return this.recommendationService.save(recommendationRequestDTO);
    }

    @GetMapping(path = "/all")
    public List<RecommendationResponseDTO> getAll(){
        return this.recommendationService.getAllRecommendation();
    }

    @GetMapping(path = "/{id}")
    public RecommendationResponseDTO get(@PathVariable("id") Long id){
        return this.recommendationService.getRecommendation(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.recommendationService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public RecommendationResponseDTO update(@PathVariable("id") Long id, @RequestBody RecommendationRequestDTO recommendationRequestDTO){
        return this.recommendationService.update(id, recommendationRequestDTO);
    }
}
