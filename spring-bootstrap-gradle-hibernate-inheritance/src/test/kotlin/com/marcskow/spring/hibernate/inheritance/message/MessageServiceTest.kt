package com.marcskow.spring.hibernate.inheritance.message

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import java.awt.TrayIcon
import javax.persistence.EntityManager

//@ActiveProfiles(profiles = ["test"])
@DataJpaTest
class MessageServiceTest {

    @Autowired
    private lateinit var messageRepository: MessageRepository<Message>

    @Autowired
    private lateinit var optionMessageRepository: MessageRepository<OptionMessage>

    @Autowired
    private lateinit var textMessageRepository: TextMessageRepository

    @Autowired
    private var em: EntityManager? = null

    @Test
    fun createUserTest() {
        val op = OptionMessage(messageType = TrayIcon.MessageType.WELCOME, payload = "xDD", options = "some,options")
        messageRepository.save(op)

        assertThat(messageRepository.findByMessageType(MessageType.WELCOME, PageRequest.of(0, 5)).totalElements)
                .isEqualTo(1)
    }

    @Test
    fun findOptionMessage() {
        val op = OptionMessage(messageType = MessageType.WELCOME, payload = "xDD", options = "some,options")
        messageRepository.save(op)

        assertThat(optionMessageRepository.findByEntityName().size).isEqualTo(1)
    }

    @Test
    fun findTextMessage() {
        val op = OptionMessage(messageType = MessageType.WELCOME, payload = "xDD", options = "some,options")
        messageRepository.save(op)

        val list = textMessageRepository.findByEntityName()

        assertThat(textMessageRepository.findByEntityName().size).isEqualTo(0)
    }

    @Test
    fun selectSpecificTest() {
        val op = OptionMessage(messageType = MessageType.WELCOME, payload = "xDD", options = "some,options")
        messageRepository.save(op)

        val tm = TextMessage(messageType = MessageType.WELCOME, payload = "xDD")
        messageRepository.save(tm)

        val m = Message(messageType = MessageType.WELCOME, payload = "xDD", payloadType = MessagePayloadType.CURRENCY)
        messageRepository.save(m)
    }
}
