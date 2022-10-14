package com.akata.studentservice.dto;

import com.akata.studentservice.entities.Location;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentResponseDTO {
    private Long id;
    private String username;
    private Location location;
    private String firstname;
    private String level;
    private String school;
    private String bio;
    private String school_career;
    private String current_position;
    private LocalDate creation;
    private String photo;
    private String github;
    private String linkedin;
    private int average;
    private String email;
    private String phone;
    private String dob;
    private String cv;
    private boolean activated;
    private int project_on_progress;
    private int project_finished;
}
