package com.marcskow.complex.criteria.api.pet

import javax.persistence.*

@Entity
@Table(name = "attributes")
data class PetAttribute(
        @Id
        @Column(name = "attribute_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        var attributeName: String? = null,

        var attributeValue: String? = null,

        @ManyToMany(mappedBy = "attributes")
        var pets: List<Pet> = emptyList()
)