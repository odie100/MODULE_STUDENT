package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.ExperienceRequestDTO;
import com.akata.studentservice.dto.ExperienceResponseDTO;
import com.akata.studentservice.services.interfaces.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping(path = "/getById/{id}")
    public ExperienceResponseDTO get(@PathVariable("id") Long id){
        return this.experienceService.get(id);
    }

    @PostMapping(path = "/save")
    public ExperienceResponseDTO save (@RequestBody ExperienceRequestDTO experienceRequestDTO){
        return this.experienceService.save(experienceRequestDTO);
    }

    @PostMapping(path = "/delete/{id}")
    public boolean delete(Long id){
        return this.experienceService.delete(id);
    }

    @GetMapping(path = "/all")
    public List<ExperienceResponseDTO> getAll(){
        return this.experienceService.getAllExperiences();
    }

    @PutMapping(path = "/update/{id}")
    public ExperienceResponseDTO update(@PathVariable Long id, @RequestBody ExperienceRequestDTO experienceRequestDTO){
        return this.experienceService.update(id, experienceRequestDTO);
    }
}
