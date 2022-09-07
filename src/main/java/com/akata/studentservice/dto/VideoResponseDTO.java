package com.akata.studentservice.dto;

import com.akata.studentservice.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class VideoResponseDTO {
    Long id;
    String video_name;
    String video_description;
    Student student;
}
