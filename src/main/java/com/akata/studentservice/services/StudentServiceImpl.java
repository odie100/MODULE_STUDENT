package com.akata.studentservice.services;

import com.akata.studentservice.dto.StudentRequestDTO;
import com.akata.studentservice.dto.StudentResponseDTO;
import com.akata.studentservice.entities.Student;
import com.akata.studentservice.mapper.StudentMapper;
import com.akata.studentservice.repository.StudentRepository;
import com.akata.studentservice.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public StudentResponseDTO save(StudentRequestDTO studentRequestDTO) {
        studentRequestDTO.setCreation(LocalDate.now());
        Student saved_student = studentRepository.save(studentMapper.studentRequestDTOStudent(studentRequestDTO));
        return studentMapper.studentToStudentResponseDTO(saved_student);
    }

    @Override
    public StudentResponseDTO getStudent(Long id) {
        return studentMapper.studentToStudentResponseDTO(studentRepository.findById(id).get());
    }

    @Override
    public StudentResponseDTO update(Long id, StudentRequestDTO studentRequestDTO) {
        Student student = studentMapper.studentRequestDTOStudent(studentRequestDTO);
        student.setId(id);
        return studentMapper.studentToStudentResponseDTO(studentRepository.save(student));
    }

    @Override
    public boolean delete(Long id) {
        try {
            studentRepository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> studentMapper.studentToStudentResponseDTO(student)).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDTO signIn(String email, String password) {
        Student student = this.studentRepository.login(email, password);
        StudentResponseDTO studentResponseDTO = null;
        if(student.getFirstname()!= null | !student.getFirstname().isEmpty()){
            studentResponseDTO = this.studentMapper.studentToStudentResponseDTO(student);
        }
        return studentResponseDTO;
    }
}
