package com.ricardo.carcollection.domain.exception;


import javax.persistence.EntityExistsException;

public class UserLoginAlreadyExistsException extends EntityExistsException {

    private static final long serialVersionUID = 1L;

    public UserLoginAlreadyExistsException(String message) {
        super(message);
    }

    public UserLoginAlreadyExistsException(Long id, String login) {
        this("Login already exists: %s".formatted(login));
    }

}
