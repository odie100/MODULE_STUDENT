package com.akata.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RegistrationStudentModel {
    String country;
    String address;
    String town;
    String username;
    String password;
    String firstname;
    String school;
    String level;
    String school_career;
    String bio;
    String email;
    String tel;
    String current_position;
    Long id_location;
}
