package edu.miu.cs489.satellite.service;

import edu.miu.cs489.satellite.dto.request.SatelliteRequestDto;
import edu.miu.cs489.satellite.dto.response.SatelliteResponseDto;

public interface SatelliteService {
    SatelliteResponseDto createSatellite(SatelliteRequestDto satellite);
    SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto satellite);
}
