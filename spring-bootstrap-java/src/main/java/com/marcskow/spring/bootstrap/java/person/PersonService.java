package com.marcskow.spring.bootstrap.java.person;

import com.marcskow.spring.bootstrap.java.common.Page;
import com.marcskow.spring.bootstrap.java.common.ResultPage;
import com.marcskow.spring.bootstrap.java.person.model.Person;
import com.marcskow.spring.bootstrap.java.person.model.PersonDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResultPage<Person> fetchPersons(Page page) {
        return new ResultPage<>(personRepository.findAll(page.asPageRequest()));
    }

    public void createPerson(PersonDto personDto) {
        Person person = new Person();
        person.updateBy(personDto);

        personRepository.save(person);
    }

    public PersonDto retrievePersonById(long id) {
        return personRepository
                .findById(id)
                .map(PersonDto::fromPerson)
                .orElseThrow(() -> new PersonNotFound(format("Person of id(%d) not found", id)));
    }

    @Transactional
    public void updatePerson(long id, PersonDto personDto) {
        Person person = personRepository
                .findById(id)
                .orElseThrow(() -> new PersonNotFound(format("Cannot update person of id(%d). Person not found.", id)));
        person.updateBy(personDto);
        personRepository.save(person);
    }

    public void deletePerson(long id) {
        Person person = personRepository
                .findById(id)
                .orElseThrow(() -> new PersonNotFound(format("Cannot update person of id(%d). Person not found.", id)));
        personRepository.delete(person);
    }
}
