package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Possess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PossessRepository extends JpaRepository<Possess, Long> {

    @Query("SELECT p FROM Possess p where p.student.id = ?1")
    List<Possess> getAllByIdStudent(Long id);

    @Query("SELECT p FROM Possess p WHERE p.student.id = ?1")
    Possess getByStudent(Long id);
}
