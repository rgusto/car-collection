package com.ricardo.carcollection.domain.exception;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class UserNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(UUID id) {
        this("User with id %s not found".formatted(id));
    }

}
