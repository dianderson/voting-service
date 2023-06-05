package com.test.sicredi.votingservice.infraestructure.kafka.producers

import com.test.sicredi.avro.VotingFieldAvro
import com.test.sicredi.avro.VotingResultAvro
import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaVotingFieldsModel
import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaVotingResultModel
import com.test.sicredi.votingservice.infraestructure.kafka.resources.PublishVotingResult
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class VotingResultProducer(
    @Value("\${configs.kafka.topics.voting-result.name}")
    private val topicName: String,
    @Value("\${configs.kafka.topics.voting-result.ttl-in-days}")
    private val topicTtl: Long,
    private val kafkaTemplate: KafkaTemplate<String, Any>
) : PublishVotingResult {
    private val logger = LogManager.getLogger(VotingResultProducer::class.java)
    override fun execute(message: KafkaVotingResultModel) {
        message.toAvro()
            .buildMessageWithPayload()
            .publicWithCallback()
    }

    private fun KafkaVotingResultModel.toAvro() = VotingResultAvro.newBuilder()
        .setCode(code)
        .setAgendaCode(agendaCode)
        .setStartTime(startTime.toString())
        .setDurationInMinutes(durationInMinutes)
        .setEndTime(endTime.toString())
        .setAllowedRoles(allowedRoles.map { it.name }.reduce { a, b -> "$a,$b" })
        .setFields(fields.map { it.toAvro() })
        .setIsSingleVote(isSingleVote)
        .build()

    private fun KafkaVotingFieldsModel.toAvro() = VotingFieldAvro.newBuilder()
        .setName(name)
        .setQuantity(quantity)
        .build()

    private fun VotingResultAvro.buildMessageWithPayload() = MessageBuilder.withPayload(this)
        .setHeader("version", "1.0.0")
        .setHeader("endOfLife", LocalDate.now().plusDays(topicTtl))
        .setHeader(KafkaHeaders.TOPIC, topicName)
        .setHeader(KafkaHeaders.KEY, code)
        .build()

    private fun Message<VotingResultAvro>.publicWithCallback() {
        try {
            kafkaTemplate.send(this)
            logger.info("Message posted: $this")
        } catch (ex: Exception) {
            logger.error("The message $this generated error $ex")
        }
    }
}