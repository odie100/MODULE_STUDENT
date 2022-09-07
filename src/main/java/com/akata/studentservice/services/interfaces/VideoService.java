package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.VideoRequestDTO;
import com.akata.studentservice.dto.VideoResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    VideoResponseDTO save (VideoRequestDTO videoRequestDTO);
    VideoResponseDTO get (Long id);
    List<VideoResponseDTO> getAll();
    List<VideoResponseDTO> getAllByStudent(Long id);
    boolean delete (String video_name, Long id_student);

    String uploadVideo(MultipartFile video) throws IOException;
}
