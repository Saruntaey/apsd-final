package edu.miu.cs489.satellite.dto.response;

import edu.miu.cs489.satellite.dto.request.SatelliteRequestDto;

import java.util.List;

public record AstronautResponseDto (
        Long id,
        String firstName,
        String lastName,
        Integer experienceYears,
        List<SatelliteResponseDto> satellites
){
}
