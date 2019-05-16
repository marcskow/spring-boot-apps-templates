package com.marcskow.spring.bootstrap.tests.mocked;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.name FROM User u WHERE u.id = :id")
    String findNameById(@Param("name") Long id);
}
