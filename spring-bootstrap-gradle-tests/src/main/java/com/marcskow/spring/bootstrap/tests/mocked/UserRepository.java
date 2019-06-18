package com.marcskow.spring.bootstrap.tests.mocked;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.name FROM User u WHERE u.id = :id")
    String findNameById(@Param("id") Long id);

    NameOnly findFirstById(@Param("id") Long id);

    @Query("SELECT u.id FROM User u WHERE u.name = :name")
    List<Long> findIdByName(@Param("name") String name);
}
