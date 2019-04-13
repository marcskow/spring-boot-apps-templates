package com.marcskow.complex.criteria.api.person

import com.marcskow.complex.criteria.api.person.model.Person
import com.marcskow.complex.criteria.api.person.model.Person_
import com.marcskow.complex.criteria.api.pet.PetAttribute_
import com.marcskow.complex.criteria.api.pet.PetRepository
import com.marcskow.complex.criteria.api.pet.Pet_
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Service
class PersonServiceJoin(private val personRepository: PersonRepository,
                        private val petRepository: PetRepository) {

    companion object {
        private val names = listOf("Marcin", "Michal", "Marek", "Jakub", "Tadeusz", "Roman", "ktos", "inny")
    }

    @PersistenceContext
    private lateinit var session: EntityManager

    fun fetchPersonHavingPetWithName(name: String): List<Person> {
        val cb = session.criteriaBuilder
        val query = cb.createQuery(Person::class.java)

        val person = query.from(Person::class.java)
        val pets = person.join(Person_.pets)

        query.select(person)
                .where(cb.equal(pets.get(Pet_.name), name))

        val typedQuery = session.createQuery(query)
        return typedQuery.resultList
    }

    fun fetchPersonHavingPetWithNameAndAttributeType(name: String, attName: String, attValue: String): List<Person> {
        val cb = session.criteriaBuilder
        val query = cb.createQuery(Person::class.java)

        val person = query.from(Person::class.java)
        val pets = person.join(Person_.pets)
        val attributes = pets.join(Pet_.attributes)

        query.select(person)
                .where(cb.and(
                        cb.equal(pets.get(Pet_.name), name),
                        cb.equal(attributes.get(PetAttribute_.attributeName), attName),
                        cb.equal(attributes.get(PetAttribute_.attributeValue), attValue))
                )

        val typedQuery = session.createQuery(query)
        return typedQuery.resultList
    }
}
