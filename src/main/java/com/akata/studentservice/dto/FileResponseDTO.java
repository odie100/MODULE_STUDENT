package com.akata.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class FileResponseDTO {
    private String filename;
    private String download_uri;
    private String type;
    private Long size;
}