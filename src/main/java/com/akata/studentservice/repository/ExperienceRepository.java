package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Experience e SET e.details = ?1 WHERE e.id = ?2")
    int update(String details, Long id);
}
