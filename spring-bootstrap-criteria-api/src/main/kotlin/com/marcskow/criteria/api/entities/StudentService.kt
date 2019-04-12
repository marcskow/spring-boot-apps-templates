package com.marcskow.criteria.api.entities

import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import kotlin.random.Random


@Service
class StudentService(
        private val studentRepository: StudentRepository
) {

    @PersistenceContext
    private lateinit var session: EntityManager

    fun fetchStudents(): List<Student> {
        val cb = session.criteriaBuilder
        val criteriaQuery = cb.createQuery(Student::class.java)

        val root = criteriaQuery.from(Student::class.java)
        criteriaQuery.select(root).where(cb.equal(root.get(Student_.gradYear), 5))

        val query = session.createQuery(criteriaQuery)
        return query.resultList
    }

    fun createStudents() {
        (1..100).forEach {
            val student = Student(it, "firstName$it", "lastName$it", Random.nextInt(10))
            studentRepository.save(student)
        }
    }
}