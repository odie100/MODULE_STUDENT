package com.akata.studentservice.dto;

import com.akata.studentservice.entities.Speciality;
import com.akata.studentservice.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RetainRequestDTO {
    Student student;
    Speciality speciality;
}
