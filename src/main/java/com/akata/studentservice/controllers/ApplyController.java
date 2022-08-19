package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.ApplyRequestDTO;
import com.akata.studentservice.dto.ApplyResponseDTO;
import com.akata.studentservice.model.ApplyModel;
import com.akata.studentservice.model.ConfirmationModel;
import com.akata.studentservice.services.interfaces.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @GetMapping(path = "/{id}")
    public ApplyResponseDTO get(@PathVariable("id") Long id){
        return this.applyService.getApply(id);
    }

    @GetMapping(path = "/all")
    public List<ApplyResponseDTO> getAll(){
        return this.applyService.getAllApplies();
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.applyService.delete(id);
    }

    @PutMapping(path = "/update/{id}")
    public ApplyResponseDTO update(@PathVariable("id") Long id, @RequestBody ApplyRequestDTO applyRequestDTO){
        return this.applyService.update(id, applyRequestDTO);
    }

    @PostMapping(path = "/insert")
    public ApplyResponseDTO insert(@RequestBody ApplyModel applyModel){
        return this.applyService.save(applyModel);
    }

    @GetMapping(path = "/getAll/{id}")
    public List<ApplyResponseDTO> getAppliesByStudentId(@PathVariable("id") Long id){
        return this.applyService.getAllAppliesByIdStudent(id);
    }

    @PostMapping(path = "/confirm")
    public int confirm(@RequestBody ConfirmationModel confirmationModel){
        return this.applyService.confirm(confirmationModel);
    }

    @GetMapping(path = "/getAllByOffer/{id}")
    public List<ApplyResponseDTO> getAppliesByOfferId(@PathVariable("id") Long id){
        return this.applyService.getAllAppliesByIdOffer(id);
    }

    @GetMapping(path = "/getAllConfirmed/{id}")
    public List<ApplyResponseDTO> getAllConfirmedApplies(@PathVariable("id") Long id){
        return this.applyService.getConfirmedApply(id);
    }
}
