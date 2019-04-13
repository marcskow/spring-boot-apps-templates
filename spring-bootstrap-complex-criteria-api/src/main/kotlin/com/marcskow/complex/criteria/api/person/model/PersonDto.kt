package com.marcskow.complex.criteria.api.person.model

import com.marcskow.complex.criteria.api.pet.PetDto

data class PersonDto(
        val id: Long = 0,
        val firstName: String,
        val lastName: String,
        val age: Int,
        val phoneNumber: Long,
        val pets: Set<PetDto>
)