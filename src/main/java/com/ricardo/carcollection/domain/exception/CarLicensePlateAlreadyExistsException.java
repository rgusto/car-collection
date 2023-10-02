package com.ricardo.carcollection.domain.exception;


import javax.persistence.EntityExistsException;

public class CarLicensePlateAlreadyExistsException extends EntityExistsException {

    private static final long serialVersionUID = 1L;

    public CarLicensePlateAlreadyExistsException(String message) {
        super(message);
    }

    public CarLicensePlateAlreadyExistsException(Long id, String licensePlate) {
        this("License plate already exists: %s".formatted(licensePlate));
    }

}
