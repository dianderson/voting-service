package com.test.sicredi.votingservice.infraestructure.kafka.resources

import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaRegisterVotingModel

interface PublishVotingRegistration {
    fun execute(message: KafkaRegisterVotingModel)
}