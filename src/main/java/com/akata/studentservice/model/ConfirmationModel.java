package com.akata.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ConfirmationModel {
    private Long id_apply;
    private Long id_student;
    private Long id_client;
    private Long id_offer;
    private String client_name;
    private String student_name;
}
