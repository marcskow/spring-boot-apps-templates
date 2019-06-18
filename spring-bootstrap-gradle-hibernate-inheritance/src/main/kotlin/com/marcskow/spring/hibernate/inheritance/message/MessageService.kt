package com.marcskow.spring.hibernate.inheritance.message

import org.springframework.stereotype.Service
import org.springframework.web.context.annotation.SessionScope

@Service
@SessionScope
class MessageService(private val messageRepository: MessageRepository<Message>) {

    fun fetchMessageRandomlyByType(type: MessageType): Message? {
        return messageRepository.findOneByMessageTypeRandomly(type)
    }
}
