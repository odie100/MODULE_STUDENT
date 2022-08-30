package com.akata.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RatingRequestDTO {
    Long id_student;
    Long id_client;
    Integer value;
}
