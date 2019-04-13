package com.marcskow.complex.criteria.api.person

import com.marcskow.complex.criteria.api.person.model.Person
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : CrudRepository<Person, Long> {
    fun findAll(pageable: Pageable): Page<Person>
}
