package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.domains.agenda.models.AgendaModel
import com.test.sicredi.votingservice.infraestructure.db.models.DbAgendaModel

fun DbAgendaModel.toAgendaModel() = AgendaModel(
    code = id,
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