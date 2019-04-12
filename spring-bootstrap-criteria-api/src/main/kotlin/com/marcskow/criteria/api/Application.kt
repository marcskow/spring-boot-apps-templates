package com.marcskow.criteria.api

import com.marcskow.criteria.api.entities.Student
import com.marcskow.criteria.api.entities.StudentService
import com.marcskow.criteria.api.entities.User
import com.marcskow.criteria.api.entities.UserRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class Application(
        private val userRepository: UserRepository,
        private val studentService: StudentService
) {

    @GetMapping("/example")
    fun exampleRest(): String {
        createUsers()



        return "default message"
    }

    fun createUsers() {
        (1..100).forEach {
            val user = User(0, "username$it", "first$it", "last$it")
            userRepository.save(user)
        }
    }

    @GetMapping("/students")
    fun getStudents(): List<Student> {
        studentService.createStudents()
        return studentService.fetchStudents()
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
