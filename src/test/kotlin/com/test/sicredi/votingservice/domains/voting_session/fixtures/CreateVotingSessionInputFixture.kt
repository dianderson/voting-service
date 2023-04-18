package com.test.sicredi.votingservice.domains.voting_session.fixtures

import com.test.sicredi.votingservice.api.v1.dto.requests.VotingRolesRequest
import com.test.sicredi.votingservice.domains.voting_session.inputs.CreateVotingSessionInput
import java.time.LocalDateTime
import java.util.*

class CreateVotingSessionInputFixture private constructor() {
    companion object {
        fun newCreateVotingSessionInput(
            code: String = UUID.randomUUID().toString(),
            startTime: LocalDateTime = LocalDateTime.now(),
            agendaCode: String = UUID.randomUUID().toString(),
            durationInMinutes: Long = 1,
            allowedRoles: List<VotingRolesRequest> = listOf(VotingRolesRequest.USER),
            votingFields: List<String> = listOf("USER"),
            isSingleVote: Boolean = false
        ) = CreateVotingSessionInput(
            code = code,
            startTime = startTime,
            agendaCode = agendaCode,
            durationInMinutes = durationInMinutes,
            allowedRoles = allowedRoles,
            votingFields = votingFields,
            isSingleVote = isSingleVote
        )
    }
}
