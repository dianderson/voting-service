package com.test.sicredi.votingservice.infraestructure.kafka.consumers

import com.test.sicredi.avros.VotingRegistrationAvro
import com.test.sicredi.votingservice.common.enums.Roles
import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaRegisterVotingModel
import com.test.sicredi.votingservice.infraestructure.kafka.port.KafkaPort
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.logging.log4j.LogManager
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneOffset

@Component
class VoteRegistrationConsumer(
    private val kafkaPort: KafkaPort
) {
    private val logger = LogManager.getLogger(VoteRegistrationConsumer::class.java)

    @KafkaListener(
        topics = ["\${configs.kafka.topics.voting-registration.name}"],
        groupId = "\${configs.kafka.group-id}"
    )
    fun onListener(message: ConsumerRecord<String, VotingRegistrationAvro>, ack: Acknowledgment) {
        try {
            kafkaPort.processVoteRegistration(message.value().buildModel())
            ack.acknowledge()
        } catch (ex: Exception) {
            logger.error("Error: $ex")
        }
    }

    private fun VotingRegistrationAvro.buildModel() = KafkaRegisterVotingModel(
        userName = userName,
        votingSessionCode = votingSessionCode,
        votedField = votedField,
        userRoles = userRoles.split(",").map { Roles.valueOf(it) },
        instant = LocalDateTime.ofEpochSecond(instant, 0, ZoneOffset.UTC)
    )
}