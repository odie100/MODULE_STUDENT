package com.akata.studentservice.dto;

import com.akata.studentservice.entities.Speciality;
import com.akata.studentservice.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RetainResponseDTO {
    Long id;
    Student student;
    Speciality speciality;
}
