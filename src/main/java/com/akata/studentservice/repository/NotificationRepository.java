package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE Notification n SET n.status = 'read' WHERE n.id_student = ?1")
    void updateStatus(Long id);

    @Query("SELECT n FROM Notification n WHERE n.id_student = ?1")
    List<Notification> getByStudent(Long id);
}
