package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.api.v1.requests.CreateAgendaRequest
import com.test.sicredi.votingservice.api.v1.requests.CreateVotingSessionRequest
import com.test.sicredi.votingservice.domains.agenda.inputs.CreateAgendaInput
import com.test.sicredi.votingservice.domains.voting_session.inputs.CreateVotingSessionInput

fun CreateAgendaRequest.toCreateAgendaInput() = CreateAgendaInput(
    name = name!!,
    subject = subject!!,
    comments = comments!!,
    startTime = startTime!!,
    durationInHours = durationInHours!!
)

fun CreateVotingSessionRequest.toCreateVotingSessionInput() = CreateVotingSessionInput(
    agendaCode = agendaCode!!,
    startTime = startTime!!,
    durationInMinutes = durationInMinutes!!,
    allowedRoles = allowedRoles!!
)