package com.marcskow.spring.hibernate.inheritance.message

enum class Actor {
    BOT, USER
}

enum class MessageType {
    WELCOME, WELCOME_ANSWER, QUESTION, ANSWER, OTHER, GOODBYE
}

enum class MessagePayloadType {
    DSL, TEXT, INTEGER, DOUBLE, DATE, CURRENCY, JSON, ENUM, OPTIONS
}
