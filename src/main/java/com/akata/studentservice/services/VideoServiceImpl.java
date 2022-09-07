package com.akata.studentservice.services;

import com.akata.studentservice.dto.VideoRequestDTO;
import com.akata.studentservice.dto.VideoResponseDTO;
import com.akata.studentservice.entities.Video;
import com.akata.studentservice.mapper.VideoMapper;
import com.akata.studentservice.repository.VideoRepository;
import com.akata.studentservice.services.interfaces.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public VideoResponseDTO save(VideoRequestDTO videoRequestDTO) {
        Video video = this.videoMapper.videoRequestDTOVideo(videoRequestDTO);
        return this.videoMapper.videoToVideoResponse(this.videoRepository.save(video));
    }

    @Override
    public VideoResponseDTO get(Long id) {
        return this.videoMapper.videoToVideoResponse(this.videoRepository.findById(id).get());
    }

    @Override
    public List<VideoResponseDTO> getAll() {
        List<Video> videos = this.videoRepository.findAll();
        return videos.stream().map(video -> this.videoMapper.videoToVideoResponse(video)).collect(Collectors.toList());
    }

    @Override
    public List<VideoResponseDTO> getAllByStudent(Long id) {
        List<Video> videos = this.videoRepository.findVideoByStudentId(id);
        return videos.stream().map(video -> this.videoMapper.videoToVideoResponse(video)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(String video_name, Long id_student) {
        try {
            this.videoRepository.delete(video_name, id_student);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public String uploadVideo(MultipartFile video) throws IOException {
        return this.fileStorageService.saveVideo(video);
    }
}
