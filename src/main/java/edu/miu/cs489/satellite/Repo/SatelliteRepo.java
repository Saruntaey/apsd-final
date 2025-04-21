package edu.miu.cs489.satellite.Repo;

import edu.miu.cs489.satellite.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepo extends JpaRepository<Satellite, Long> {
}
