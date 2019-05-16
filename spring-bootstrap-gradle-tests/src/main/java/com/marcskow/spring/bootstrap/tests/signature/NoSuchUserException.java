package com.marcskow.spring.bootstrap.tests.signature;

public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException(Long id) {
        super("No such user exception");
    }
}
