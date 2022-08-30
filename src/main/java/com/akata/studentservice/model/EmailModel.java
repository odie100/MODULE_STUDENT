package com.akata.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel {
    private String to;
    private String from;
    private String subject;
    private String text;
    private String template;
    private String client_name;
    private String student_name;
    private Map<String, Object> properties;
}
