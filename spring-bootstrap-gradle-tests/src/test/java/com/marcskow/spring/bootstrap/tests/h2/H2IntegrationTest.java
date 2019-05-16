package com.marcskow.spring.bootstrap.tests.h2;

import com.marcskow.spring.bootstrap.tests.mocked.User;
import com.marcskow.spring.bootstrap.tests.mocked.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class H2IntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUserTest() {
        // given
        User user = new User();
        user.setName("Marcin Skowron");

        // when
        userRepository.save(user);

        // then
        assertThat(userRepository.findAll().stream().map(User::getName)).contains("Marcin Skowron");
    }
}
