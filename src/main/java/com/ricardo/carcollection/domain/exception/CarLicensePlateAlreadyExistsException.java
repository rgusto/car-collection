package com.ricardo.carcollection.domain.exception;

import jakarta.persistence.EntityExistsException;

import java.util.UUID;

public class CarLicensePlateAlreadyExistsException extends EntityExistsException {

    private static final long serialVersionUID = 1L;

    public CarLicensePlateAlreadyExistsException(String message) {
        super(message);
    }

    public CarLicensePlateAlreadyExistsException(UUID id, String licensePlate) {
        this("License plate already exists: %s".formatted(licensePlate));
    }

}
