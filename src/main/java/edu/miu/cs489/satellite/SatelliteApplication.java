package edu.miu.cs489.satellite;

import edu.miu.cs489.satellite.dto.request.AstronautRequestDto;
import edu.miu.cs489.satellite.dto.request.SatelliteRequestDto;
import edu.miu.cs489.satellite.model.OrbitType;
import edu.miu.cs489.satellite.model.Satellite;
import edu.miu.cs489.satellite.service.AstronautService;
import edu.miu.cs489.satellite.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SatelliteApplication {
	private final SatelliteService satelliteService;
	private final AstronautService astronautService;

	public static void main(String[] args) {
		SpringApplication.run(SatelliteApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			SatelliteRequestDto[] satellites = new SatelliteRequestDto[]{
					new SatelliteRequestDto("Hubble", "1990-04-24", OrbitType.LEO, false),
					new SatelliteRequestDto("Starlink-17", "2023-08-14", OrbitType.MEO, false),
					new SatelliteRequestDto("Sentinel-16", "2020-11-21", OrbitType.LEO, true),
			};

			AstronautRequestDto[] astros = new AstronautRequestDto[]{
					new AstronautRequestDto("Neil", "Armstrong", 12, null),
					new AstronautRequestDto("Sally", "Ride", 8, null),
					new AstronautRequestDto("Chris", "Hadfield", 15, null),
			};

			Arrays.stream(satellites).forEach(satelliteService::createSatellite);
			Arrays.stream(astros).forEach(astronautService::createAstronaut);
		};
	}

}
