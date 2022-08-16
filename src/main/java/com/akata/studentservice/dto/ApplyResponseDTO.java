package com.akata.studentservice.dto;

import com.akata.studentservice.entities.Student;
import com.akata.studentservice.model.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Transient;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ApplyResponseDTO {
    Long id;
    Long offer_id;
    LocalDate apply_date;
    String status;
    Float price;
    String message;

    Student student;
    Offer offer;
}
