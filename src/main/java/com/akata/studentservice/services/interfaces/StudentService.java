package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.StudentRequestDTO;
import com.akata.studentservice.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO save(StudentRequestDTO studentRequestDTO);
    StudentResponseDTO getStudent(Long id);

    StudentResponseDTO update(Long id, StudentRequestDTO studentRequestDTO);

    boolean delete(Long id);
    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO signIn(String email, String password);
}
