package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s JOIN Contact ct on s.id = ct.user.id WHERE ct.value = ?1 AND s.password = ?2")
    Student login(String email, String password);
}
