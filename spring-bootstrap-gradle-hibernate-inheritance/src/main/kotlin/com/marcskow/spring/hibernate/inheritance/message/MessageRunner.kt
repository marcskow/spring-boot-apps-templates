package com.marcskow.spring.hibernate.inheritance.message

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class MessageRunner : ApplicationRunner {

    @Autowired
    private lateinit var messageRepository: MessageRepository<Message>

    override fun run(args: ApplicationArguments?) {
        val op = OptionMessage(messageType = MessageType.WELCOME, payload = "xDD", options = "some,options")
        messageRepository.save(op)

        val tm = TextMessage(messageType = MessageType.WELCOME, payload = "xDD")
        messageRepository.save(tm)

        val m = Message(messageType = MessageType.WELCOME, payload = "xDD", payloadType = MessagePayloadType.CURRENCY)
        messageRepository.save(m)
    }
}
