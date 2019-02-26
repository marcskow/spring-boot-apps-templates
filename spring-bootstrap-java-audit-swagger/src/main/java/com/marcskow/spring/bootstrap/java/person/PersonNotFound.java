package com.marcskow.spring.bootstrap.java.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class PersonNotFound extends RuntimeException {
    PersonNotFound(String message) {
        super(message);
    }
}
