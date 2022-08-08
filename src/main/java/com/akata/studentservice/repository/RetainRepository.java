package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Retain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetainRepository extends JpaRepository<Retain, Long> {
    @Query("SELECT r FROM Retain r WHERE r.student.id = ?1")
    List<Retain> findByIdStudent(Long id);

    @Query("DELETE FROM Retain r where r.student.id = ?1")
    Retain deleteByIdStudent(Long id);
}
