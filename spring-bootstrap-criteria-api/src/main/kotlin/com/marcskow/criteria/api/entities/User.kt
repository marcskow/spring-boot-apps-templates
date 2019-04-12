package com.marcskow.criteria.api.entities

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
        @Id
        @Column(name = "user_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        var username: String,
        var firstName: String,
        var lastName: String
)
