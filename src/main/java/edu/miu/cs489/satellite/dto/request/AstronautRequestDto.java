package edu.miu.cs489.satellite.dto.request;

import edu.miu.cs489.satellite.model.Satellite;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

public record AstronautRequestDto (
        String firstName,
        String lastName,
        Integer experienceYears,
        List<Long> satelliteIds
){
}
