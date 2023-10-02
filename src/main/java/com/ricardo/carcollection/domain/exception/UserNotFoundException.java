package com.ricardo.carcollection.domain.exception;


import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Long id) {
        this("User with id %s not found".formatted(id));
    }

}
