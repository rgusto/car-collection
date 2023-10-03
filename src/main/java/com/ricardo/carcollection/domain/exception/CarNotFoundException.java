package com.ricardo.carcollection.domain.exception;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class CarNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(UUID id) {
        this("Car with id %s not found".formatted(id));
    }

}
