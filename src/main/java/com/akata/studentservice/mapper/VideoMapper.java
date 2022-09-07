package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.VideoRequestDTO;
import com.akata.studentservice.dto.VideoResponseDTO;
import com.akata.studentservice.entities.Video;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoMapper {
    VideoResponseDTO videoToVideoResponse(Video video);
    Video videoRequestDTOVideo (VideoRequestDTO videoRequestDTO);
    Video videoResponseToVideo(VideoResponseDTO videoResponseDTO);
}
