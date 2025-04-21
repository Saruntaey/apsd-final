package edu.miu.cs489.satellite.service.impl;

import edu.miu.cs489.satellite.Repo.SatelliteRepo;
import edu.miu.cs489.satellite.dto.request.SatelliteRequestDto;
import edu.miu.cs489.satellite.dto.response.SatelliteResponseDto;
import edu.miu.cs489.satellite.exception.satellite.SatelliteCannotUpdate;
import edu.miu.cs489.satellite.exception.satellite.SatelliteNotFoundException;
import edu.miu.cs489.satellite.mapper.SatelliteMapper;
import edu.miu.cs489.satellite.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepo satelliteRepo;
    private final SatelliteMapper satelliteMapper;

    @Override
    public SatelliteResponseDto createSatellite(SatelliteRequestDto satellite) {
        var s = satelliteMapper.satelliteRequestDtoToSatellite(satellite);
        return satelliteMapper.satelliteToSatelliteResponseDto(satelliteRepo.save(s));
    }

    @Override
    public SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto satellite) {
        var s = satelliteRepo.findById(id);
        if (s.isEmpty()) {
            throw new SatelliteNotFoundException(id);
        }
        if (s.get().isDecommissioned()) {
            throw new SatelliteCannotUpdate("Decommissioned satellite cannot update");
        }
        var updated = satelliteMapper.satelliteRequestDtoToSatellite(satellite);
        updated.setId(id);
        return satelliteMapper.satelliteToSatelliteResponseDto(satelliteRepo.save(updated));
    }
}
