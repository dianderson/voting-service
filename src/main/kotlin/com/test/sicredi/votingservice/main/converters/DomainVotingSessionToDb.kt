package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.domains.voting_session.inputs.CreateVotingSessionInput
import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateVotingSessionInput

fun CreateVotingSessionInput.toDbCreateVotingSessionInput() = DbCreateVotingSessionInput(
    id = code,
    agendaCode = agendaCode,
    startTime = startTime,
    durationInMinutes = durationInMinutes,
    allowedRoles = allowedRoles,
    votingFields = votingFields,
    isSingleVote = isSingleVote
)