package com.cottages.backend.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AmenityNotFoundException extends RuntimeException {

    public AmenityNotFoundException(Long id) {
        super("Amenity with id " + id + " not found");
    }
}