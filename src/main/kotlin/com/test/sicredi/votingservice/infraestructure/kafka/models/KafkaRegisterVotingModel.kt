package com.test.sicredi.votingservice.infraestructure.kafka.models

import com.test.sicredi.votingservice.common.enums.Roles
import java.time.LocalDateTime

data class KafkaRegisterVotingModel(
    val votingSessionCode: String,
    val votedField: String,
    val userRoles: List<Roles>,
    val instant: LocalDateTime
)