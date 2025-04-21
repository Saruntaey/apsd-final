package edu.miu.cs489.satellite.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="satellite_id")
    private Long id;
    @Column(unique = true)
    private String name;
    private LocalDate launchDate;
    private boolean decommissioned;
    @Enumerated(EnumType.STRING)
    private OrbitType orbitType;
    @ManyToMany(mappedBy = "satellites")
    private List<Astronaut> astronauts;
}
