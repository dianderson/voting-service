package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.api.v1.responses.AgendaResponse
import com.test.sicredi.votingservice.api.v1.responses.VotingSessionResponse
import com.test.sicredi.votingservice.domains.agenda.models.AgendaModel
import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel

fun AgendaModel.toAgendaResponse() = AgendaResponse(
    code = code,
    name = name,
    subject = subject
)

fun VotingSessionModel.toVotingSessionResponse() = VotingSessionResponse(
    code = code
)