package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {
    @Query("SELECT a FROM Apply a where a.student.id = ?1")
    List<Apply> getApplyByIdStudent(Long id_student);
}
