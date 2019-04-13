package com.marcskow.complex.criteria.api.pet

data class PetDto(
        val name: String, val type: String
) {
    fun asPet(): Pet {
        val pet = Pet()
        pet.name = name
        pet.type = type
        return pet
    }
}