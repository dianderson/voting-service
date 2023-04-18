package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput
import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaRegisterVotingModel

fun KafkaRegisterVotingModel.toProcessVoteInput() = ProcessVoteInput(
    userName = userName,
    votingSessionCode = votingSessionCode,
    votedField = votedField,
    userRoles = userRoles,
    instant = instant
)