package com.marcskow.spring.bootstrap.tests.unit;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class DataReader {
    public ZonedDateTime readZonedDateTime(String date) {
        return ZonedDateTime.parse(date);
    }
}
