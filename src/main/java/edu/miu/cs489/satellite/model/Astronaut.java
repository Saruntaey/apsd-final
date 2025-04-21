package edu.miu.cs489.satellite.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Astronaut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="astronaut_id")
    private Long id;
    private String firstName;
    private String lastName;
    private Integer experienceYears;
    @ManyToMany
    @JoinTable(name="astronaut_satellite",
            joinColumns=
            @JoinColumn(name="astronaut_id"),
            inverseJoinColumns=
            @JoinColumn(name="satellite_id")
    )
    private List<Satellite> satellites;
}

