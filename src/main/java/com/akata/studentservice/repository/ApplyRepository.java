package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {
    @Query("SELECT a FROM Apply a where a.student.id = ?1")
    List<Apply> getApplyByIdStudent(Long id_student);

    @Query("SELECT a FROM Apply a where a.offer_id = ?1")
    List<Apply> getApplyByIdOffer(Long id_offer);
    @Modifying
    @Transactional
    @Query("UPDATE Apply a SET a.status = 'confirmed' where a.student.id = ?1")
    int update(Long id);
}
