package edu.miu.cs489.satellite.mapper;

import edu.miu.cs489.satellite.dto.request.SatelliteRequestDto;
import edu.miu.cs489.satellite.dto.response.SatelliteResponseDto;
import edu.miu.cs489.satellite.model.Satellite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DateMapper.class})
public interface SatelliteMapper {
    @Mapping(source = "launchDate", target = "launchDate", qualifiedByName = "stringToLocalDate")
    Satellite satelliteRequestDtoToSatellite(SatelliteRequestDto satelliteRequestDto);
    @Mapping(source = "launchDate", target = "launchDate", qualifiedByName = "localDateToString")
    SatelliteResponseDto satelliteToSatelliteResponseDto(Satellite satellite);
}
