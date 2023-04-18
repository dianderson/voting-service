package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.domains.voting.models.RegisterUserVoteModel
import com.test.sicredi.votingservice.infraestructure.db.inputs.DbRegisterUserVoteInput

fun RegisterUserVoteModel.toDbCreateAgendaInput() = DbRegisterUserVoteInput(
    votingSessionCode = votingSessionCode,
    votingField = votingField,
    userName = userName
)