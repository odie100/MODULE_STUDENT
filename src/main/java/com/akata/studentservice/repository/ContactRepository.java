package com.akata.studentservice.repository;

import com.akata.studentservice.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("SELECT c FROM Contact c where c.student.id = ?1")
    List<Contact> findAllByIdUser(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Contact c SET  c.value = ?1 WHERE c.student.id = ?2 AND c.type = 'email'")
    int updateEmail(String value, Long student_id);

    @Modifying
    @Transactional
    @Query("UPDATE Contact c SET c.value = ?1 WHERE c.student.id = ?2 AND c.type = 'tel'")
    int updateTel(String value, Long student_id);

    @Query("SELECT c FROM Contact c WHERE c.type = ?1 and c.student.id = ?2")
    Contact findExisting(String type, Long id);
}
