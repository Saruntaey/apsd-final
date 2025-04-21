package edu.miu.cs489.satellite.Repo;

import edu.miu.cs489.satellite.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronautRepo extends JpaRepository<Astronaut, Long> {
}
