package com.marcskow.complex.criteria.api.person.model

import com.marcskow.complex.criteria.api.pet.Pet
import javax.persistence.*

@Entity
@Table(name = "persons")
data class Person(
        @Id
        @Column(name = "person_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        var firstName: String? = null,

        var lastName: String? = null,

        var age: Int = 0,

        var phoneNumber: Long = 0,

        @ManyToMany
        @JoinTable(
                name = "persons_pets",
                joinColumns = [JoinColumn(name = "person_id", referencedColumnName = "person_id")],
                inverseJoinColumns = [JoinColumn(name = "pet_id", referencedColumnName = "pet_id")])
        var pets: List<Pet> = emptyList()
)