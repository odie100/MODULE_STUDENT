package com.akata.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ApplyModel {
    Long id_student;
    Long id_offer;
    String message;
    Float price;
}
