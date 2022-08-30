package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.RatingRequestDTO;
import com.akata.studentservice.dto.RatingResponseDTO;
import com.akata.studentservice.entities.Rating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingResponseDTO ratingToRatingResponse(Rating rating);
    Rating ratingRequestDTORating (RatingRequestDTO ratingRequestDTO);
    Rating ratingResponseToRating(RatingResponseDTO ratingResponseDTO);
}
