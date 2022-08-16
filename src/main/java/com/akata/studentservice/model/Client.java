package com.akata.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Client {
    private Long id;
    private String username;
    private String name;
    private String type;
    private String description;
    private LocalDate creation;

    private Location location;
}
