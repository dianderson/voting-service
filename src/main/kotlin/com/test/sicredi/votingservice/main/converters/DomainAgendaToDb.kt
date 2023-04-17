package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.domains.agenda.inputs.CreateAgendaInput
import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateAgendaInput

fun CreateAgendaInput.toDbCreateAgendaInput() = DbCreateAgendaInput(
    id = code,
    name = name,
    subject = subject,
    comments = comments,
    startTime = startTime,
    durationInHours = durationInHours
)