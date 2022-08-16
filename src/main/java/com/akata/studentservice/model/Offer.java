package com.akata.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Offer {
    private Long offer_id;
    private String theme;
    private String details;
    private LocalDate deadline;
    private LocalDate post_date;
    private Float budget;
    private int applicant_number;
    private Client client;
    private Category category;
}
