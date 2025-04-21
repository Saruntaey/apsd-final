package edu.miu.cs489.satellite.dto.response;

import edu.miu.cs489.satellite.model.OrbitType;

import java.time.LocalDate;

public record SatelliteResponseDto(
        Long id,
        String name,
        LocalDate launchDate,
        boolean decommissioned,
        OrbitType orbitType
) {
}
