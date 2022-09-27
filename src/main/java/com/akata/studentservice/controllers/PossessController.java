package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.PossessRequestDTO;
import com.akata.studentservice.dto.PossessResponseDTO;
import com.akata.studentservice.model.ExperienceModel;
import com.akata.studentservice.services.interfaces.PossessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/possess")
public class PossessController {

    @Autowired
    private PossessService possessService;

    @GetMapping(path = "/{id}")
    public PossessResponseDTO get(@PathVariable Long id){
        return this.possessService.get(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(Long id){
        return this.possessService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public PossessResponseDTO update(@PathVariable("id") Long id, @RequestBody ExperienceModel experienceModel){
        return this.possessService.update(id, experienceModel);
    }

    @GetMapping(path = "/all")
    public List<PossessResponseDTO> getAll(){
        return this.possessService.getAllPossesses();
    }

    @GetMapping(path = "/allByStudent/{id}")
    public List<PossessResponseDTO> getAllByStudent(@PathVariable Long id){
        return this.possessService.getAllPossessesByIdStudent(id);
    }
}
