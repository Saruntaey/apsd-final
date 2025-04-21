package edu.miu.cs489.satellite.exception.satellite;

public class SatelliteNotFoundException extends RuntimeException {
    public SatelliteNotFoundException(Long id) {
        super("Satellite with id " + id + " not found");
    }
}
