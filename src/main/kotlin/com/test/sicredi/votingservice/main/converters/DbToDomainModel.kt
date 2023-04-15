package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.api.v1.responses.AgendaResponse
import com.test.sicredi.votingservice.api.v1.responses.VotingSessionResponse
import com.test.sicredi.votingservice.infraestructure.db.models.DbAgendaModel
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel

fun DbAgendaModel.toAgendaResponse() = AgendaResponse(
    code = id,
    name = name,
    subject = subject
)

fun DbVotingSessionModel.toVotingSessionResponse() = VotingSessionResponse(
    code = id
)