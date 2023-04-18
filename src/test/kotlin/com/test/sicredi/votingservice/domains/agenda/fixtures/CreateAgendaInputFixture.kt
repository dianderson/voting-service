package com.test.sicredi.votingservice.domains.agenda.fixtures

import com.test.sicredi.votingservice.domains.agenda.inputs.CreateAgendaInput
import java.time.LocalDateTime
import java.util.*

class CreateAgendaInputFixture private constructor() {
    companion object {
        fun newCreateAgendaInput(
            code: String = UUID.randomUUID().toString(),
            name: String = "Agenda name",
            subject: String = "Agenda subject",
            comments: String = "Agenda comments",
            startTime: LocalDateTime = LocalDateTime.now(),
            durationInHours: Long = 1
        ) = CreateAgendaInput(
            code = code,
            name = name,
            subject = subject,
            comments = comments,
            startTime = startTime,
            durationInHours = durationInHours
        )
    }
}
