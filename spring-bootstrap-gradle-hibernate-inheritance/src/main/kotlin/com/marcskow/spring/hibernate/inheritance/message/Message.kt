package com.marcskow.spring.hibernate.inheritance.message

import javax.persistence.*
import javax.validation.constraints.NotNull


@Open
@Entity
@Table(name = "messages")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MTYPE", discriminatorType = DiscriminatorType.STRING)
class Message(
        @Id
        @Column(name = "message_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Enumerated(EnumType.STRING)
        val messageType: MessageType,

        @Enumerated(EnumType.STRING)
        val payloadType: MessagePayloadType,

        @Column(length = 2048)
        @NotNull
        val payload: String
)

@Entity
@DiscriminatorValue("TEXT")
class TextMessage(
        id: Long = 0,
        messageType: MessageType,
        payload: String
) : Message(id, messageType, MessagePayloadType.TEXT, payload)

@Entity
@DiscriminatorValue("OPTIONS")
class OptionMessage(
        id: Long = 0,
        messageType: MessageType,
        payload: String,
        val options: String
) : Message(id, messageType, MessagePayloadType.OPTIONS, payload)
