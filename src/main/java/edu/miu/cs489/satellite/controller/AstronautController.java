package edu.miu.cs489.satellite.controller;

import edu.miu.cs489.satellite.dto.request.AstronautRequestDto;
import edu.miu.cs489.satellite.dto.response.AstronautResponseDto;
import edu.miu.cs489.satellite.model.Astronaut;
import edu.miu.cs489.satellite.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {
    private final AstronautService astronautService;

    @GetMapping
    public ResponseEntity<List<AstronautResponseDto>> getAstronauts() {
        var r = astronautService.getAstronauts();
        return ResponseEntity.status(HttpStatus.OK).body(r);
    }

    @PostMapping
    public ResponseEntity<AstronautResponseDto> createAstronaut(@RequestBody AstronautRequestDto astronautRequestDto) {
        var r = astronautService.createAstronaut(astronautRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(r);
    }
}
