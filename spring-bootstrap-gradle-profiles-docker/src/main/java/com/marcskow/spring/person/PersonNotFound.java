package com.marcskow.spring.person;

class PersonNotFound extends RuntimeException {
    PersonNotFound(String message) {
        super(message);
    }
}
