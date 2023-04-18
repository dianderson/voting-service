package com.test.sicredi.votingservice.infraestructure.kafka.producers

import com.test.sicredi.avros.VotingRegistrationAvro
import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaRegisterVotingModel
import com.test.sicredi.votingservice.infraestructure.kafka.resources.PublishVotingRegistration
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.ZoneOffset

@Component
class VoteRegistrationProducer(
    @Value("\${configs.kafka.topics.voting-registration.name}")
    private val topicName: String,
    @Value("\${configs.kafka.topics.voting-registration.ttl-in-days}")
    private val topicTtl: Long,
    private val kafkaTemplate: KafkaTemplate<String, Any>
) : PublishVotingRegistration {
    private val logger = LogManager.getLogger(VoteRegistrationProducer::class.java)
    override fun execute(message: KafkaRegisterVotingModel) {
        message.toAvro()
            .buildMessageWithPayload()
            .publicWithCallback()
    }

    private fun KafkaRegisterVotingModel.toAvro() = VotingRegistrationAvro.newBuilder()
        .setUserName(userName)
        .setVotingSessionCode(votingSessionCode)
        .setVotedField(votedField)
        .setUserRoles(userRoles.map { it.name }.reduce { a, b -> "$a,$b" })
        .setInstant(instant.toEpochSecond(ZoneOffset.UTC))
        .build()

    private fun VotingRegistrationAvro.buildMessageWithPayload() = MessageBuilder.withPayload(this)
        .setHeader("version", "1.0.0")
        .setHeader("endOfLife", LocalDate.now().plusDays(topicTtl))
        .setHeader(KafkaHeaders.TOPIC, topicName)
        .setHeader(KafkaHeaders.KEY, "$votingSessionCode-$votedField")
        .build()

    private fun Message<VotingRegistrationAvro>.publicWithCallback() {
        try {
            kafkaTemplate.send(this) //TODO PROBLEMA NO AVRO FIELD USERNAME
            logger.info("Message posted: $this")
        } catch (ex: Exception) {
            logger.error("The message $this generated error $ex")
        }
    }
}