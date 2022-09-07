package com.akata.studentservice.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String school;
    private String level;
    private String school_career;
    private String current_position;
    private String photo;
    private String github;
    private String linkedin;
    private String cv;
    private String dob;
    @Lob
    private String bio;

    @Transient
    private int average;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    Location location;

    private LocalDate creation;
}
