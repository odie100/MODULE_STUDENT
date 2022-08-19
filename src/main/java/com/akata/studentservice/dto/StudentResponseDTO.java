package com.akata.studentservice.dto;

import com.akata.studentservice.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
