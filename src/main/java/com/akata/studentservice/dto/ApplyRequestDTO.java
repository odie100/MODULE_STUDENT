package com.akata.studentservice.dto;

import com.akata.studentservice.entities.Student;
import com.akata.studentservice.model.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ApplyRequestDTO {
    Student student;
    Offer offer;
    String message;
    Float price;
}
