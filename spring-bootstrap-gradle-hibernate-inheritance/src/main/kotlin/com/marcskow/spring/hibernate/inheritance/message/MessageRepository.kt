package com.marcskow.spring.hibernate.inheritance.message

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository
import java.util.*

@NoRepositoryBean
interface MkJpaRepository<V, K> : CrudRepository<V, K> {
    fun findAll(pageable: Pageable): Page<V>
}

fun <V, K> MkJpaRepository<V, K>.findOneRandomly(): V? {
    val count = count()
    return findAll(PageRequest.of(Random().nextInt(count.toInt()), 1))
            .content
            .firstOrNull()
}

@Repository
interface MessageRepository<T : Message> : MkJpaRepository<T, Long> {
    @Query("SELECT m from #{#entityName} m")
    fun findByEntityName(): List<T>

    @Query("SELECT m from Message m where TYPE(m) = :type")
    fun findByType(type: String): List<Message>

    fun findByMessageType(messageType: MessageType, pageable: Pageable): Page<Message>
}

fun MessageRepository<Message>.findOneByMessageTypeRandomly(type: MessageType): Message? {
    val count = count()
    return findByMessageType(type, PageRequest.of(Random().nextInt(count.toInt()), 1))
            .content
            .firstOrNull()
}

@Repository
interface OptionMessageRepository : MkJpaRepository<OptionMessage, Long> {
    @Query("SELECT m from Message m where TYPE(m) = :type")
    fun findByType(type: String): List<Message>

    fun findByMessageType(messageType: MessageType, pageable: Pageable): Page<Message>
}

@Repository
interface TextMessageRepository : MessageRepository<TextMessage>
