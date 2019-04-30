package com.marcskow.spring.person;

import com.marcskow.spring.person.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PersonRepository extends CrudRepository<Person, Long> {
    Page<Person> findAll(Pageable pageable);
}
