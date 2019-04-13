package com.marcskow.complex.criteria.api.pet

import com.marcskow.complex.criteria.api.person.model.Person
import javax.persistence.*

@Entity
@Table(name = "pets")
data class Pet(
        @Id
        @Column(name = "pet_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        var name: String? = null,

        var type: String? = null,

        @ManyToMany(mappedBy = "pets")
        var persons: List<Person> = emptyList(),

        @ManyToMany
        @JoinTable(
                name = "pets_attributes",
                joinColumns = [JoinColumn(name = "pet_id", referencedColumnName = "pet_id")],
                inverseJoinColumns = [JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id")])
        var attributes: List<PetAttribute> = emptyList()
)