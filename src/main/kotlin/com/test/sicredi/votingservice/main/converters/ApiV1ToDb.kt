package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.api.v1.requests.CreateAgendaRequest
import com.test.sicredi.votingservice.api.v1.requests.CreateVotingSessionRequest
import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateAgendaInput
import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateVotingSessionInput
import java.util.*

fun CreateAgendaRequest.toDbCreateAgendaInput() = DbCreateAgendaInput(
    id = UUID.randomUUID().toString(),
    name = name!!,
    subject = subject!!,
    comments = comments!!,
    startTime = startTime!!,
    durationInHours = durationInHours!!
)

fun CreateVotingSessionRequest.toDbCreateVotingSessionInput() = DbCreateVotingSessionInput(
    id = UUID.randomUUID().toString(),
    agendaCode = agendaCode!!,
    startTime = startTime!!,
    durationInMinutes = durationInMinutes!!,
    allowedRoles = allowedRoles!!
)