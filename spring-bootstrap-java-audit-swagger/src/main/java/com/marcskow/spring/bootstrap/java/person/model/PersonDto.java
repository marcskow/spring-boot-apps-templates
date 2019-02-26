package com.marcskow.spring.bootstrap.java.person.model;

import com.marcskow.spring.bootstrap.java.pet.PetDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private long phoneNumber;
    private Set<PetDto> pets;
}