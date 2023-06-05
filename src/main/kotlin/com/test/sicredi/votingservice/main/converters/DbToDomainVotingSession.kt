package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.domains.voting_session.models.VotingFieldsModel
import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel

fun DbVotingSessionModel.toVotingSessionModel() = VotingSessionModel(
    code = id,
    agenda = agenda.toAgendaModel(),
    startTime = startTime,
    durationInMinutes = durationInMinutes,
    endTime = endTime,
    allowedRoles = allowedRoles,
    fields = fields.map { VotingFieldsModel(it.name, it.quantity) },
    isSingleVote = isSingleVote,
    createdAt = createdAt,
    createdBy = createdBy,
    updatedAt = updatedAt,
    updatedBy = updatedBy
)