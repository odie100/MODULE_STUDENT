package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findVideoByStudentId(Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Video v WHERE v.video_name = ?1 AND v.student.id = ?2")
    void delete(String video_name, Long student_id);
}
