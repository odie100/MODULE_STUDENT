package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT AVG(value) from Rating r where r.id_student = ?1")
    String average(Long id);
}
