package com.test.sicredi.votingservice.domains.agenda.models

import java.time.LocalDateTime

data class AgendaModel(
    val code: String,
    val name: String,
    val subject: String,
    val comments: String,
    val startTime: LocalDateTime,
    val durationInHours: Long,
    val createdAt: LocalDateTime,
    val createdBy: String,
    val updatedAt: LocalDateTime,
    val updatedBy: String
)