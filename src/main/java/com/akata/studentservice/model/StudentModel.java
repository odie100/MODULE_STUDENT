package com.akata.studentservice.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class StudentModel {
    private Long id;
    private String username;
    private String firstname;
    private String school;
    private String level;
    private String school_career;
    private String bio;
    private String country;
    private String address;
    private String town;
    private String email;
    private String tel;
    private String current_position;
    private String photo;
    private String cv;
}
