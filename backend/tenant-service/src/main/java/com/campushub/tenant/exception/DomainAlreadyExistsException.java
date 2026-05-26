package com.campushub.tenant.exception;

public class DomainAlreadyExistsException
        extends RuntimeException {

    public DomainAlreadyExistsException(String message) {
        super(message);
    }
}