package com.test.sicredi.votingservice.domains.agenda.fixtures

import com.test.sicredi.votingservice.domains.agenda.models.AgendaModel
import java.time.LocalDateTime
import java.util.*

class AgendaModelFixture private constructor() {
    companion object {
        fun newAgendaModel(
            code: String = UUID.randomUUID().toString(),
            name: String = "Agenda name",
            subject: String = "Agenda subject",
            comments: String = "Agenda comments",
            startTime: LocalDateTime = LocalDateTime.now(),
            durationInHours: Long = 1,
            createdAt: LocalDateTime = LocalDateTime.now(),
            createdBy: String = "system",
            updatedAt: LocalDateTime = LocalDateTime.now(),
            updatedBy: String = "system"
        ) = AgendaModel(
            code = code,
            name = name,
            subject = subject,
            comments = comments,
            startTime = startTime,
            durationInHours = durationInHours,
            createdAt = createdAt,
            createdBy = createdBy,
            updatedAt = updatedAt,
            updatedBy = updatedBy
        )
    }
}
