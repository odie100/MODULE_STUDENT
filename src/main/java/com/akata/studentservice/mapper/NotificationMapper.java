package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.NotificationRequestDTO;
import com.akata.studentservice.dto.NotificationResponseDTO;
import com.akata.studentservice.entities.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationResponseDTO NotificationToResponse(Notification notification);
    Notification RequestToNotification(NotificationRequestDTO notificationRequestDTO);
}
