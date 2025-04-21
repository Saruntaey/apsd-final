package edu.miu.cs489.satellite.service.impl;

import edu.miu.cs489.satellite.Repo.AstronautRepo;
import edu.miu.cs489.satellite.Repo.SatelliteRepo;
import edu.miu.cs489.satellite.dto.request.AstronautRequestDto;
import edu.miu.cs489.satellite.dto.response.AstronautResponseDto;
import edu.miu.cs489.satellite.exception.satellite.SatelliteNotFoundException;
import edu.miu.cs489.satellite.mapper.AstronautMapper;
import edu.miu.cs489.satellite.model.Satellite;
import edu.miu.cs489.satellite.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {
    private final AstronautRepo astronautRepo;
    private final AstronautMapper astronautMapper;
    private final SatelliteRepo satelliteRepo;

    @Override
    public AstronautResponseDto createAstronaut(AstronautRequestDto astronautRequestDto) {
        var a = astronautMapper.astronautRequestDtoToAstronaut(astronautRequestDto);
        List<Satellite> satellites = new ArrayList<>();
        if (a.getSatellites() != null) {
            a.getSatellites().forEach(satellite -> {
                Optional<Satellite> s = satelliteRepo.findById(satellite.getId());
                if (s.isEmpty()) {
                    throw new SatelliteNotFoundException(satellite.getId());
                }
                satellites.add(s.get());
            });
            a.setSatellites(satellites);
        }
        return astronautMapper.astronautToAstronautResponseDto(astronautRepo.save(a));
    }

    @Override
    public List<AstronautResponseDto> getAstronauts() {
        return astronautRepo.findAll().stream().map(astronautMapper::astronautToAstronautResponseDto).collect(Collectors.toList());
    }
}
