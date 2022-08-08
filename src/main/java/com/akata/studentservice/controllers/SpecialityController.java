package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.SpecialityRequestDTO;
import com.akata.studentservice.dto.SpecialityResponseDTO;
import com.akata.studentservice.services.interfaces.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/speciality")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;

    @GetMapping(path = "/all")
    public List<SpecialityResponseDTO> getAll(){
        return this.specialityService.getAll();
    }

    @PostMapping(path = "/insert")
    public SpecialityResponseDTO add(@RequestBody SpecialityRequestDTO specialityRequestDTO){
        return this.specialityService.add(specialityRequestDTO);
    }
}
