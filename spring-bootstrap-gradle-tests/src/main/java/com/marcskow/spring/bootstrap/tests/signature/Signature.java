package com.marcskow.spring.bootstrap.tests.signature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Signature {
    private final String fullName;
    private final ZonedDateTime date;
}
