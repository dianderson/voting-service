package com.test.sicredi.votingservice.domains.voting_session.inputs

import com.test.sicredi.votingservice.api.v1.dto.requests.VotingRolesRequest
import java.time.LocalDateTime
import java.util.*

data class CreateVotingSessionInput(
    val code: String = UUID.randomUUID().toString(),
    val agendaCode: String,
    val startTime: LocalDateTime,
    val durationInMinutes: Long,
    val allowedRoles: List<VotingRolesRequest>,
    val votingFields: List<String>,
    val isSingleVote: Boolean
)