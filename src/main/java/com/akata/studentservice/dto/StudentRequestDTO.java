package com.akata.studentservice.dto;

import com.akata.studentservice.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StudentRequestDTO {
    private String username;
    private String password;
    private Location location;
    private String firstname;
    private String level;
    private String school;
    private String school_career;
    private String dob;
    private String bio;
    private LocalDate creation;
    private String current_position;
    private String photo;
    private String github;
    private String linkedin;
    private String cv;
}
