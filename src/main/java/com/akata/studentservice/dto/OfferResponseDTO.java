package com.akata.studentservice.dto;

import com.akata.studentservice.model.Category;
import com.akata.studentservice.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OfferResponseDTO {
    private Long offer_id;
    private String theme;
    private String details;
    private LocalDate deadline;
    private LocalDate post_date;
    private int applicant_number;

    private Float budget;

    Client client;
    Category category;
}
