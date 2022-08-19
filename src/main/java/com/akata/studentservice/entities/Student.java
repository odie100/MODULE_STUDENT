package com.akata.studentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Lob
    private String bio;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    Location location;

    private LocalDate creation;
}
