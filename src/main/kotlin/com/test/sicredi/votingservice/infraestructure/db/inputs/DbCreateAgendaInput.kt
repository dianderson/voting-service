package com.test.sicredi.votingservice.infraestructure.db.inputs

import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.AgendaEntity
import java.time.LocalDateTime

data class DbCreateAgendaInput(
    val id: String,
    val name: String,
    val subject: String,
    val comments: String,
    val startTime: LocalDateTime,
    val durationInHours: Long
) {
    fun toEntity() = AgendaEntity(
        id = id,
        name = name,
        subject = subject,
        comments = comments,
        startTime = startTime,
        durationInHours = durationInHours
    )
}
