package com.ricardo.carcollection.domain.exception;

import jakarta.persistence.EntityExistsException;

import java.util.UUID;

public class UserLoginAlreadyExistsException extends EntityExistsException {

    private static final long serialVersionUID = 1L;

    public UserLoginAlreadyExistsException(String message) {
        super(message);
    }

    public UserLoginAlreadyExistsException(UUID id, String login) {
        this("Login already exists: %s".formatted(login));
    }

}
