package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.StudentRequestDTO;
import com.akata.studentservice.dto.StudentResponseDTO;
import com.akata.studentservice.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentResponseDTO studentToStudentResponseDTO(Student student);
    Student studentRequestDTOStudent(StudentRequestDTO studentRequestDTO);
    Student studentResponseDTOStudent(StudentResponseDTO studentResponseDTO);
}
