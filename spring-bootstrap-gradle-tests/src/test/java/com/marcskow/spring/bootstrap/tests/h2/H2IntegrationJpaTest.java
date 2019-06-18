package com.marcskow.spring.bootstrap.tests.h2;

import com.marcskow.spring.bootstrap.tests.mocked.Config;
import com.marcskow.spring.bootstrap.tests.mocked.ConfigDto;
import com.marcskow.spring.bootstrap.tests.mocked.ConfigRepository;
import com.marcskow.spring.bootstrap.tests.mocked.Department;
import com.marcskow.spring.bootstrap.tests.mocked.DepartmentRepository;
import com.marcskow.spring.bootstrap.tests.mocked.User;
import com.marcskow.spring.bootstrap.tests.mocked.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class H2IntegrationJpaTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

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

    @SuppressWarnings("unchecked")
    @Test
    void selectUserQueryTest() {
        // given
        User user = new User();
        user.setName("Marcin Skowron");
        userRepository.save(user);

        // when
        Query q = em.createQuery("SELECT u FROM User u");

        // then
        assertThat(q.getResultList().stream().map(o -> ((User) o).getName())).contains("Marcin Skowron");
    }

    @Test
    void selectUserTypedQueryTest() {
        // given
        User user = new User();
        user.setName("Marcin Skowron");
        userRepository.save(user);

        // when
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u", User.class);

        // then
        assertThat(q.getResultList().stream().map(User::getName)).contains("Marcin Skowron");
    }

    @Test
    void selectUserByNameTypedQueryTest() {
        // given
        User user = new User();
        user.setName("Marcin Skowron");
        userRepository.save(user);

        // when
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class);
        q.setParameter("name", "Marcin Skowron");

        // then
        assertThat(q.getResultList().stream().map(User::getName)).contains("Marcin Skowron");
    }

    @Test
    void selectUserByNameOrdinalParameterTypedQueryTest() {
        // given
        User user = new User();
        user.setName("Marcin Skowron");
        userRepository.save(user);

        // when
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.name = ?1", User.class);
        q.setParameter(1, "Marcin Skowron");

        // then
        assertThat(q.getResultList().stream().map(User::getName)).contains("Marcin Skowron");
    }

    @Test
    void selectUserNamedQueryTest() {
        // given
        User user = new User();
        user.setName("Marcin Skowron");
        userRepository.save(user);

        // when
        TypedQuery<User> q = em.createNamedQuery(User.Q.findUserByName, User.class);
        q.setParameter("name", "Marcin Skowron");

        // then
        assertThat(q.getResultList().stream().map(User::getName)).contains("Marcin Skowron");
    }

    @Test
    void selectOnlyOneColumnTest() {
        // given
        User user = new User();
        user.setName("Marcin Skowron");
        userRepository.save(user);

        // when
        TypedQuery<String> q = em.createQuery("SELECT u.name FROM User u WHERE u.name = :name", String.class);
        q.setParameter("name", "Marcin Skowron");

        // then
        assertThat(q.getSingleResult()).isEqualTo("Marcin Skowron");
    }

    @Test
    void selectOnlySomeColumnsTest() {
        // given
        Department department = new Department();
        department.setName("Dep1");
        departmentRepository.save(department);

        Config config = new Config();
        config.setName("Conf1");
        config.setDepartment(department);
        configRepository.save(config);

        // when
        TypedQuery<ConfigDto> q = em.createNamedQuery(Config.Q.findAllConfigs, ConfigDto.class);

        // then
        assertThat(q.getResultList()).hasSize(1);
        assertThat(q.getResultList().get(0).getDepartmentName()).isEqualTo("Dep1");
    }
}
