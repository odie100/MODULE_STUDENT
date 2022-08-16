package com.akata.studentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String place;
    String theme;
    String tech;
    String details;
}
