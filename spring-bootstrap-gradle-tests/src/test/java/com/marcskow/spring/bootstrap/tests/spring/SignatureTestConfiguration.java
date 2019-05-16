package com.marcskow.spring.bootstrap.tests.spring;

import com.marcskow.spring.bootstrap.tests.mocked.User;
import com.marcskow.spring.bootstrap.tests.mocked.UserRepository;
import com.marcskow.spring.bootstrap.tests.unit.DateReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Profile("spring-test")
@Configuration
public class SignatureTestConfiguration {

    @Bean
    public DateReader createDateReader() {
        return new DateReader();
    }

    @Bean
    public UserRepository createUserRepository() {
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(15L)).thenReturn(Optional.of(user()));
        return userRepository;
    }

    private User user() {
        User user = new User();
        user.setId(15L);
        user.setName("Marcin Skowrix");
        return user;
    }
}
