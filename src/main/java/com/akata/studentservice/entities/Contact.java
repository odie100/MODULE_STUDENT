package com.akata.studentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String type;
    String value;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;
}
