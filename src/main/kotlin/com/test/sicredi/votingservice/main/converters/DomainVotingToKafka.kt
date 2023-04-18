package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput
import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaRegisterVotingModel

fun RegisterVoteInput.toKafkaRegisterVotingModel() = KafkaRegisterVotingModel(
    votingSessionCode = votingSessionCode,
    votedField = votedField,
    userRoles = userRoles,
    instant = instant
)