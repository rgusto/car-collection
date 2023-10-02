package com.ricardo.carcollection.domain.exception;


import javax.persistence.EntityNotFoundException;

public class CarNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(Long id) {
        this("Car with id %s not found".formatted(id));
    }

}
