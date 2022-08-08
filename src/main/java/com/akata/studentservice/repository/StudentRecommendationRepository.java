package com.akata.studentservice.repository;

import com.akata.studentservice.entities.StudentRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRecommendationRepository extends JpaRepository<StudentRecommendation, Long> {
}
