package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.NotificationRequestDTO;
import com.akata.studentservice.dto.NotificationResponseDTO;
import com.akata.studentservice.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping(path = "/all/{id}")
    public List<NotificationResponseDTO> getNotification(@PathVariable("id") Long id){
        return this.notificationService.getNotification(id);
    }

    @PostMapping(path = "/read/{id}")
    public void read(@PathVariable("id") Long id){
        this.notificationService.read(id);
    }

    @PostMapping(path = "/add")
    public NotificationResponseDTO addNotification(@RequestBody NotificationRequestDTO notificationResponseDTO){
        return this.notificationService.addNotification(notificationResponseDTO);
    }
}
