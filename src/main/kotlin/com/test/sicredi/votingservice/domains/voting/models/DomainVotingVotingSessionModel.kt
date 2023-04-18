package com.test.sicredi.votingservice.domains.voting.models

import com.test.sicredi.votingservice.common.enums.Roles
import java.time.LocalDateTime

data class DomainVotingVotingSessionModel(
    val startTime: LocalDateTime,
    val durationInMinutes: Long,
    val allowedRoles: List<Roles>,
    val votingFields: List<String>
)
