package com.akata.studentservice.services;

import com.akata.studentservice.dto.RatingRequestDTO;
import com.akata.studentservice.dto.RatingResponseDTO;
import com.akata.studentservice.entities.Rating;
import com.akata.studentservice.mapper.RatingMapper;
import com.akata.studentservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingMapper ratingMapper;

    public RatingResponseDTO insert(RatingRequestDTO ratingRequestDTO){
        Rating rating = this.ratingMapper.ratingRequestDTORating(ratingRequestDTO);
        return this.ratingMapper.ratingToRatingResponse(this.ratingRepository.save(rating));
    }

    public int average(Long id_student){
        Integer avg = this.ratingRepository.average(id_student);
        return ( avg != null ? avg : 0 );
    }
}
