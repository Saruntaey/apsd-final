package edu.miu.cs489.satellite.exception;

import edu.miu.cs489.satellite.exception.satellite.SatelliteCannotUpdate;
import edu.miu.cs489.satellite.exception.satellite.SatelliteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SatelliteNotFoundException.class)
    public ResponseEntity<ApiError> satelliteNotFound(SatelliteNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(e.getMessage()));
    }

    @ExceptionHandler(SatelliteCannotUpdate.class)
    public ResponseEntity<ApiError> satelliteCannotUpdate(SatelliteCannotUpdate e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(e.getMessage()));
    }
}
