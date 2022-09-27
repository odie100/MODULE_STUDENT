package com.akata.studentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    /* Need to delete these fields and modify the data in front*/
/*    String place;
    String theme;
    String tech;*/
    @Lob
    String details;
}
