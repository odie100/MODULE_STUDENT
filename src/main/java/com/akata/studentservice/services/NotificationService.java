package com.akata.studentservice.services;

import com.akata.studentservice.dto.NotificationRequestDTO;
import com.akata.studentservice.dto.NotificationResponseDTO;
import com.akata.studentservice.entities.Notification;
import com.akata.studentservice.mapper.NotificationMapper;
import com.akata.studentservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationMapper notificationMapper;

    public void updateStatus(Long id){
        this.notificationRepository.updateStatus(id);
    }

   public NotificationResponseDTO addNotification(NotificationRequestDTO notificationRequestDTO){
        Notification notification = this.notificationMapper.RequestToNotification(notificationRequestDTO);
        return this.notificationMapper.NotificationToResponse(this.notificationRepository.save(notification));
   }

   public void read(Long id){
        this.notificationRepository.updateStatus(id);
   }

   public List<NotificationResponseDTO> getNotification(Long id){
        List<Notification> notificationResponseDTOS = this.notificationRepository.getByStudent(id);
        return notificationResponseDTOS.stream().map(notification -> this.notificationMapper.NotificationToResponse(notification))
                .collect(Collectors.toList());
   }
}
