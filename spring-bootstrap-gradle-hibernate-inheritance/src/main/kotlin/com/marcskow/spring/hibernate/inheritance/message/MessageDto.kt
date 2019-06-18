package com.marcskow.spring.hibernate.inheritance.message

open class MessageDto(
        val payload: String,
        val type: MessagePayloadType,
        val actor: Actor
)

class OptionsMessageDto(
        val options: List<String>,
        payload: String,
        type: MessagePayloadType,
        actor: Actor) : MessageDto(payload, type, actor)
