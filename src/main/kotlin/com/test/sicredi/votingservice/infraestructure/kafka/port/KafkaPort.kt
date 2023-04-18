package com.test.sicredi.votingservice.infraestructure.kafka.port

import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaRegisterVotingModel

interface KafkaPort {
    fun processVoteRegistration(event: KafkaRegisterVotingModel)
}