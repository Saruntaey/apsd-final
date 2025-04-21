package edu.miu.cs489.satellite.mapper;

import edu.miu.cs489.satellite.dto.request.AstronautRequestDto;
import edu.miu.cs489.satellite.dto.response.AstronautResponseDto;
import edu.miu.cs489.satellite.model.Astronaut;
import edu.miu.cs489.satellite.model.Satellite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AstronautMapper {
    @Mapping(source = "satelliteIds", target = "satellites", qualifiedByName = "idsToSatellites")
    Astronaut astronautRequestDtoToAstronaut(AstronautRequestDto astronautRequestDto);
    AstronautResponseDto astronautToAstronautResponseDto(Astronaut astronaut);

    @Named("idsToSatellites")
    public static Satellite idsToSatellites(Long id) {
        Satellite satellite = new Satellite();
        satellite.setId(id);
        return satellite;
    }
}
