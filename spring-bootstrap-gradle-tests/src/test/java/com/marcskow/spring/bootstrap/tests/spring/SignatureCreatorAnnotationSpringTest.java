package com.marcskow.spring.bootstrap.tests.spring;

import com.marcskow.spring.bootstrap.tests.mocked.UserRepository;
import com.marcskow.spring.bootstrap.tests.signature.Signature;
import com.marcskow.spring.bootstrap.tests.signature.SignatureCreator;
import com.marcskow.spring.bootstrap.tests.unit.DateReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles(profiles = "spring-test")
@SpringBootTest(classes = SignatureTestConfiguration.class) // Contains @ExtendWith(SpringExtension.class)
class SignatureCreatorAnnotationSpringTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DateReader dateReader;

    private SignatureCreator signatureCreator;

    @BeforeEach
    void setUp() {
        signatureCreator = new SignatureCreator(userRepository, dateReader);
    }

    @Test
    void createSignature() {
        Signature signature = signatureCreator.createSignature(15L, "2018-12-30T14:00+01:00");
        assertThat(signature.getDate()).isEqualTo(ZonedDateTime.of(2018, 12, 30, 13, 0, 0, 0, ZoneOffset.UTC));
    }
}
