package com.marcskow.spring.bootstrap.tests.signature;

import com.marcskow.spring.bootstrap.tests.mocked.User;
import com.marcskow.spring.bootstrap.tests.mocked.UserRepository;
import com.marcskow.spring.bootstrap.tests.unit.DateReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SignatureCreatorTest {

    private final UserRepository userRepository = mock(UserRepository.class);

    private final DateReader dateReader = new DateReader();

    private final SignatureCreator signatureCreator = new SignatureCreator(userRepository, dateReader);

    @BeforeEach
    void setUp() {
        when(userRepository.findById(5L)).thenReturn(Optional.of(user()));
    }

    @Test
    void createSignature() {
        Signature signature = signatureCreator.createSignature(5L, "2018-12-30T14:00+01:00");
        assertThat(signature.getDate()).isEqualTo(ZonedDateTime.of(2018, 12, 30, 13, 0, 0, 0, ZoneOffset.UTC));
    }

    private User user() {
        User user = new User();
        user.setId(5L);
        user.setName("Marcin Skowrix");
        return user;
    }
}
