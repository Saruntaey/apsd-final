package edu.miu.cs489.satellite.dto.request;

import edu.miu.cs489.satellite.model.OrbitType;

public record SatelliteRequestDto (
        String name,
        String launchDate,
        OrbitType orbitType,
        boolean decommissioned
){
}
