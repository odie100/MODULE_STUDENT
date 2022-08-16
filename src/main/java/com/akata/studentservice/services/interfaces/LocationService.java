package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.dto.LocationRequestDTO;
import com.akata.studentservice.dto.LocationResponseDTO;

import java.util.List;

public interface LocationService {
    LocationResponseDTO save(LocationRequestDTO locationRequestDTO);

    LocationResponseDTO getLocation(Long id);

    int update(Long id, LocationRequestDTO locationRequestDTO);

    boolean delete(Long id);

    List<LocationResponseDTO> getAllLocation();
}
