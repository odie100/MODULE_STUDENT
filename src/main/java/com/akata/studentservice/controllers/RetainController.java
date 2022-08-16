package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.RetainResponseDTO;
import com.akata.studentservice.model.RetainModel;
import com.akata.studentservice.services.interfaces.RetainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/retain")
public class RetainController {
    @Autowired
    private RetainService retainService;

    @GetMapping(path = "/all")
    public List<RetainResponseDTO> getAll(){
        return this.retainService.getAll();
    }

    @GetMapping(path = "/allByStudent/{id}")
    public List<RetainResponseDTO> getAllByIdStudent(@PathVariable("id") Long id){
        return this.retainService.getAllById(id);
    }

    @PostMapping(path = "/insert")
    public RetainResponseDTO insert(@RequestBody RetainModel retainModel){
        return this.retainService.save(retainModel);
    }
}
