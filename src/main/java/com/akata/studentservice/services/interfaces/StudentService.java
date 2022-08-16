package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.StudentRequestDTO;
import com.akata.studentservice.dto.StudentResponseDTO;
import com.akata.studentservice.model.RegistrationStudentModel;
import com.akata.studentservice.model.StudentModel;

import java.util.List;

public interface StudentService {
    StudentResponseDTO save(StudentRequestDTO studentRequestDTO);
    StudentResponseDTO getStudent(Long id);

    int update(Long id, StudentModel studentModel);

    boolean delete(Long id);
    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO signIn(String email, String password);

    StudentResponseDTO register(RegistrationStudentModel registrationStudentModel);
}