package edu.miu.cs489.satellite.service;

import edu.miu.cs489.satellite.dto.request.AstronautRequestDto;
import edu.miu.cs489.satellite.dto.response.AstronautResponseDto;

import java.util.List;

public interface AstronautService {
    AstronautResponseDto createAstronaut(AstronautRequestDto astronautRequestDto);
    List<AstronautResponseDto> getAstronauts();
}
