package com.marcskow.spring.bootstrap.tests.query;

import com.marcskow.spring.bootstrap.tests.mocked.User;
import com.marcskow.spring.bootstrap.tests.mocked.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SpringDataQueryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void selectOnlyOneColumn() {
        // given
        User user = new User();
        user.setName("Marcin Skowron");

        // when
        userRepository.save(user);
        Long id = userRepository.findIdByName("Marcin Skowron").stream().findFirst().orElseThrow();

        // then
        assertThat(userRepository.findFirstById(id).getName()).isEqualTo("Marcin Skowron");
    }

    @Test
    void selectOnlyOneColumnNoProjection() {
        // given
        User user = new User();
        user.setName("Marcin Skowron");

        // when
        userRepository.save(user);
        Long id = userRepository.findIdByName("Marcin Skowron").stream().findFirst().orElseThrow();

        // then
        assertThat(userRepository.findNameById(id)).isEqualTo("Marcin Skowron");
    }
}
