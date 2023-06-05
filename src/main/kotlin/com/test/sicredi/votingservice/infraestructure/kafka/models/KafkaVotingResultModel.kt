package com.test.sicredi.votingservice.infraestructure.kafka.models

import com.test.sicredi.votingservice.common.enums.Roles
import java.time.LocalDateTime

data class KafkaVotingResultModel(
    val code: String,
    val agendaCode: String,
    val startTime: LocalDateTime,
    val durationInMinutes: Long,
    val endTime: LocalDateTime,
    val allowedRoles: List<Roles>,
    val fields: List<KafkaVotingFieldsModel>,
    val isSingleVote: Boolean
)