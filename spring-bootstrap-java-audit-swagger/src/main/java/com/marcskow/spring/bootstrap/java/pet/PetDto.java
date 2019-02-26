package com.marcskow.spring.bootstrap.java.pet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    private String name;
    private String type;

    public Pet asPet() {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setType(type);
        return pet;
    }
}