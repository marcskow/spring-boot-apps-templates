package com.marcskow.spring.bootstrap.tests.unit;

import org.junit.jupiter.api.Test;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class DataReaderTest {

    private final DateReader dataReader = new DateReader();

    @Test
    void readZonedDateTime() {
        // given
        String givenDate = "2018-12-30T13:00+01:00";

        // when
        ZonedDateTime zonedDateTime = dataReader.readZonedDateTime(givenDate);

        // then
        ZonedDateTime expectedDate = ZonedDateTime.of(2018, 12, 30, 12, 0, 0, 0, ZoneOffset.UTC);
        assertThat(zonedDateTime).isEqualTo(expectedDate);
    }
}
