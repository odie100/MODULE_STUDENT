package com.akata.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class StudentReturnModel {
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
    private String github;
    private String linkedin;
    private int average;
}
