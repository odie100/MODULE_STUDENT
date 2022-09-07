package com.akata.studentservice.controllers;

import com.akata.studentservice.dto.VideoRequestDTO;
import com.akata.studentservice.dto.VideoResponseDTO;
import com.akata.studentservice.entities.Student;
import com.akata.studentservice.repository.StudentRepository;
import com.akata.studentservice.services.FileStorageService;
import com.akata.studentservice.services.interfaces.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping(path = "/upload/{id}")
    public VideoResponseDTO uploadVideo(@RequestParam("video") MultipartFile video, @PathVariable("id") Long id_student,
                                        @RequestParam("description") String description) throws IOException {
        String video_name = this.videoService.uploadVideo(video);
        Student student = this.studentRepository.findById(id_student).get();
        VideoRequestDTO videoRequestDTO = new VideoRequestDTO(video_name, description, student);
        return this.videoService.save(videoRequestDTO);
    }

    @GetMapping(value = "/{video_name}", produces = "video/mp4")
    public Resource loadVideo(@PathVariable("video_name") String video_name) throws IOException {
        return this.fileStorageService.loadVideo(video_name);
    }

    @GetMapping(path = "/allByStudent/{id}")
    public List<VideoResponseDTO> getAllByStudent(@PathVariable("id") Long id_student){
        return this.videoService.getAllByStudent(id_student);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@RequestParam("video_name") String video_name, @PathVariable("id") Long id){
        return this.videoService.delete(video_name, id);
    }

}
