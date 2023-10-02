package com.ricardo.carcollection.domain.exception;


import javax.persistence.EntityExistsException;

public class UserEmailAlreadyExistsException extends EntityExistsException {

    private static final long serialVersionUID = 1L;

    public UserEmailAlreadyExistsException(String message) {
        super(message);
    }

    public UserEmailAlreadyExistsException(Long id, String email) {
        this("E-mail already exists: %s".formatted(email));
    }

}
