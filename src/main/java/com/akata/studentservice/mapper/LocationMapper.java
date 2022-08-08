package com.akata.studentservice.mapper;

import com.akata.studentservice.dto.LocationRequestDTO;
import com.akata.studentservice.dto.LocationResponseDTO;
import com.akata.studentservice.entities.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationResponseDTO locationToLocationResponseDTO(Location location);
    Location locationRequestDTOLocation (LocationRequestDTO locationRequestDTO);
    Location locationResponseToLocation(LocationResponseDTO locationResponseDTO);
}
