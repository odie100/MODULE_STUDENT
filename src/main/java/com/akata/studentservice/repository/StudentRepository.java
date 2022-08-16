package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s JOIN Contact ct on s.id = ct.student.id WHERE ct.value = ?1 AND s.password = ?2")
    Student login(String email, String password);

    @Modifying
    @Transactional
    @Query("UPDATE Student s set s.username = ?1, s.firstname = ?2, s.school = ?3, s.level = ?4, s.school_career = ?5," +
            "s.bio = ?6 where s.id = ?7")
    int update(String username, String firstname, String school, String level, String school_career, String bio, Long id);

}