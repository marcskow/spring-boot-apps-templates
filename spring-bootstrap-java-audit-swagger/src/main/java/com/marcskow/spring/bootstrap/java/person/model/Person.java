package com.marcskow.spring.bootstrap.java.person.model;

import com.marcskow.spring.bootstrap.java.audit.Audit;
import com.marcskow.spring.bootstrap.java.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
public class Person extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private int age;

    private long phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "person")
    private Set<Pet> pets = new HashSet<>();

    public void updateBy(PersonDto personDto) {
        firstName = personDto.getFirstName();
        lastName = personDto.getLastName();
        age = personDto.getAge();
        phoneNumber = personDto.getPhoneNumber();

        pets = new HashSet<>();
        personDto.getPets().forEach(it -> addToPets(it.asPet()));
    }

    private void addToPets(Pet pet) {
        pet.setPerson(this);
        pets.add(pet);
    }
}