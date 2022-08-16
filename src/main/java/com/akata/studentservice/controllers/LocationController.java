package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.LocationRequestDTO;
import com.akata.studentservice.dto.LocationResponseDTO;
import com.akata.studentservice.services.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping(path = "/{id}")
    public LocationResponseDTO get(@PathVariable("id") Long id){
        return this.locationService.getLocation(id);
    }

    @GetMapping(path = "/all")
    public List<LocationResponseDTO> getAll(){
        return this.locationService.getAllLocation();
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return this.locationService.delete(id);
    }

    @PutMapping(path = "/{id}")
    public int update(@PathVariable("id") Long id, LocationRequestDTO locationRequestDTO){
        return this.locationService.update(id, locationRequestDTO);
    }

    @PostMapping(path = "/insert")
    public LocationResponseDTO insert(@RequestBody LocationRequestDTO locationRequestDTO){
        return this.locationService.save(locationRequestDTO);
    }
}
