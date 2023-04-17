package com.test.sicredi.votingservice.domains.agenda.inputs

import java.time.LocalDateTime
import java.util.*

data class CreateAgendaInput(
    val code: String = UUID.randomUUID().toString(),
    val name: String,
    val subject: String,
    val comments: String,
    val startTime: LocalDateTime,
    val durationInHours: Long
)