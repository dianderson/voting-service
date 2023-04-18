package com.test.sicredi.votingservice.domains.voting.fixtures

import com.test.sicredi.votingservice.common.enums.Roles
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import java.time.LocalDateTime

class VotingSessionModelFixture private constructor() {
    companion object {
        fun newVotingSessionModel(
            startTime: LocalDateTime = LocalDateTime.now(),
            durationInMinutes: Long = 1,
            allowedRoles: List<Roles> = listOf(Roles.USER),
            isSingleVote: Boolean = false,
            votingFields: List<String> = listOf("Yes", "No")
        ) = DomainVotingVotingSessionModel(
            startTime = startTime,
            durationInMinutes = durationInMinutes,
            allowedRoles = allowedRoles,
            isSingleVote = isSingleVote,
            votingFields = votingFields
        )
    }
}
