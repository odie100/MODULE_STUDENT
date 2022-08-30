package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.RatingRequestDTO;
import com.akata.studentservice.dto.RatingResponseDTO;
import com.akata.studentservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping(path = "/insert")
    public RatingResponseDTO insert(RatingRequestDTO ratingRequestDTO){
        return this.ratingService.insert(ratingRequestDTO);
    }

    @GetMapping(path = "/average/{id}")
    public int average(@PathVariable("id") Long id_student){
        return this.ratingService.average(id_student);
    }
}
