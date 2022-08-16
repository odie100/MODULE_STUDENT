package com.akata.studentservice.dto;

import com.akata.studentservice.entities.Experience;
import com.akata.studentservice.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PossessResponseDTO {
    Long id;
    Student student;
    Experience experience;
}
