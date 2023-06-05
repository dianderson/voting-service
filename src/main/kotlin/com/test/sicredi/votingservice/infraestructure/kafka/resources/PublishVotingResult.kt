package com.test.sicredi.votingservice.infraestructure.kafka.resources

import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaVotingResultModel

interface PublishVotingResult {
    fun execute(message: KafkaVotingResultModel)
}