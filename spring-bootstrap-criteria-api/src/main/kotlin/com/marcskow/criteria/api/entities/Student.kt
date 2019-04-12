package com.marcskow.criteria.api.entities

import javax.persistence.*


@Entity
@Table(name = "students")
data class Student(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,

        @Column(name = "first_name")
        val firstName: String? = null,

        @Column(name = "last_name")
        val lastName: String? = null,

        @Column(name = "grad_year")
        val gradYear: Int = 0
)