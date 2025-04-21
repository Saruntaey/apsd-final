package edu.miu.cs489.satellite.controller;

import edu.miu.cs489.satellite.dto.request.SatelliteRequestDto;
import edu.miu.cs489.satellite.dto.response.SatelliteResponseDto;
import edu.miu.cs489.satellite.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {
    private final SatelliteService satelliteService;
    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponseDto> updateSatellite(@PathVariable("id") Long id, @RequestBody SatelliteRequestDto satelliteRequestDto) {
        var r = satelliteService.updateSatellite(id, satelliteRequestDto);
        return ResponseEntity.ok(r);
    }
}
