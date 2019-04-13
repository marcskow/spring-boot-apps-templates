package com.marcskow.complex.criteria.api.person

import com.marcskow.complex.criteria.api.person.model.Person
import com.marcskow.complex.criteria.api.person.model.Person_
import com.marcskow.complex.criteria.api.pet.Pet
import com.marcskow.complex.criteria.api.pet.PetAttribute
import com.marcskow.complex.criteria.api.pet.PetAttributeRepository
import com.marcskow.complex.criteria.api.pet.PetRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import kotlin.random.Random


data class MyT(val id: Long, val firstName: String)

@Service
class PersonService(private val personRepository: PersonRepository,
                    private val petRepository: PetRepository,
                    private val petAttributeRepository: PetAttributeRepository) {

    companion object {
        private val personNames = listOf("Marcin", "Michal", "Marek", "Jakub", "Tadeusz", "Roman", "ktos", "inny",
                "Maciek", "Karol", "Kamil", "Bartek", "Wojtek", "Lukasz", "Piotrek", "Tomek")
    }

    @PersistenceContext
    private lateinit var session: EntityManager

    fun fetchPersonsByName(name: String): List<Person> {
        val cb = session.criteriaBuilder
        val criteriaQuery = cb.createQuery(Person::class.java)

        val root = criteriaQuery.from(Person::class.java)
        criteriaQuery.select(root).where(cb.equal(root.get(Person_.firstName), name))

        val query = session.createQuery(criteriaQuery)
        return query.resultList
    }

    fun fetchOnlyIdAndFirstName(): List<MyT> {
        val cb = session.criteriaBuilder
        val cq = cb.createQuery(MyT::class.java)

        val root = cq.from(Person::class.java)
        cq.multiselect(root.get(Person_.id), root.get(Person_.firstName))
        return session.createQuery(cq).resultList
    }

    fun fetchOnlyId(): List<Long> {
        val cb = session.criteriaBuilder
        val cq = cb.createQuery(Long::class.java)

        val root = cq.from(Person::class.java)
        cq.select(root.get(Person_.id))
        return session.createQuery(cq).resultList
    }

    fun createPersons() {
        val names = listOf("Lasik", "Niro", "Nodi", "Pikus", "Reksio", "Latek", "Lolek", "Bolek",
                "Ares", "Nela", "Pucus")
        val attributes = listOf(PetAttribute(attributeValue = "zielona", attributeName = "siersc"),
                PetAttribute(attributeValue = "niebieska", attributeName = "siersc"),
                PetAttribute(attributeValue = "czerwona", attributeName = "siersc"),
                PetAttribute(attributeValue = "tak", attributeName = "szczeka"),
                PetAttribute(attributeValue = "nie", attributeName = "szczeka"))
        val groupBy = attributes.groupBy { it.attributeName }
        attributes.forEach {
            petAttributeRepository.save(it)
        }

        (1..100).forEach {
            val person = Person(firstName = personNames.random(), lastName = "last$it",
                    age = Random.nextInt(50), phoneNumber = Random.nextLong(50000))

            val ints = Random.nextInt(3)
            val pets = ArrayList<Pet>()
            (0..ints).forEach { intt ->
                val a = Random.nextInt(3)
                val pet = Pet(name = "${names.random()}${if (a == 1) "" else "$a"}", type = "type$intt")

                if (Random.nextInt(10) % 2 == 0) {
                    pet.attributes = listOf(groupBy["siersc"]!!.random(), groupBy["szczeka"]!!.random())
                } else {
                    pet.attributes = listOf(groupBy["siersc"]!!.random())
                }

                petRepository.save(pet)
                pets.add(pet)
            }
            person.pets = pets
            personRepository.save(person)
        }
    }
}
