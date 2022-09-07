package com.akata.studentservice.entities;

import com.akata.studentservice.dto.OfferResponseDTO;
import com.akata.studentservice.model.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
    Long offer_id;
    LocalDate apply_date;
    String status;
    Float price;
    @Lob
    String message;

    @Transient
    OfferResponseDTO offer;
}
