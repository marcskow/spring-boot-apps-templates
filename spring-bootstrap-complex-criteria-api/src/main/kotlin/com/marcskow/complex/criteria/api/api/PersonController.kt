package com.marcskow.complex.criteria.api.api

import com.marcskow.complex.criteria.api.person.MyT
import com.marcskow.complex.criteria.api.person.PersonRepository
import com.marcskow.complex.criteria.api.person.PersonService
import com.marcskow.complex.criteria.api.person.PersonServiceJoin
import com.marcskow.complex.criteria.api.person.model.Person
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

data class PersonDto(val personId: Long, val personFirstName: String, val personLastName: String,
                     val pets: List<PetDto>)

data class PetDto(val petId: Long, val petName: String, val attributes: List<AttributeDto>? = emptyList())

data class AttributeDto(val name: String, val value: String)

@RestController
@RequestMapping("/api/persons")
class PersonController(
        private val personService: PersonService,
        private val personRepository: PersonRepository,
        private val personServiceJoin: PersonServiceJoin
) {

    @GetMapping("/create")
    fun createPersons(): List<Person> {
        personService.createPersons()
        return personService.fetchPersonsByName("Marcin")
    }

    @GetMapping("/get/{name}")
    fun getPersons(@PathVariable name: String): List<Person> {
        return personService.fetchPersonsByName(name)
    }

    @GetMapping("/get-all")
    fun getPersonsAll(): List<Person> {
        return personRepository.findAll(PageRequest.of(0, 500)).content
    }

    @GetMapping("/only-some")
    fun getOnlySomeFields(): List<MyT> {
        return personService.fetchOnlyIdAndFirstName()
    }

    @GetMapping("/only-id")
    fun getOnlyId(): List<Long> {
        return personService.fetchOnlyId()
    }

    @GetMapping("/with-pet-name/{pet}")
    fun getHavingPetWithName(@PathVariable pet: String): List<PersonDto> {
        return personServiceJoin.fetchPersonHavingPetWithName(pet)
                .map {
                    PersonDto(it.id, it.firstName ?: "", it.lastName ?: "", it.pets.map { pet ->
                        PetDto(pet.id, pet.name ?: "")
                    })
                }
    }

    @GetMapping("/with-attribute/{pet}")
    fun getHavingPetWithNameWithAttributeNameAndValue(@PathVariable pet: String,
                                                      @RequestParam attributeName: String,
                                                      @RequestParam attributeValue: String): List<PersonDto> {
        return personServiceJoin.fetchPersonHavingPetWithNameAndAttributeType(pet, attributeName, attributeValue)
                .map {
                    PersonDto(it.id, it.firstName ?: "", it.lastName ?: "", it.pets.map { pet ->
                        PetDto(pet.id, pet.name ?: "", pet.attributes.map { att ->
                            AttributeDto(att.attributeName ?: "", att.attributeValue
                                    ?: "")
                        })
                    })
                }
    }
}
