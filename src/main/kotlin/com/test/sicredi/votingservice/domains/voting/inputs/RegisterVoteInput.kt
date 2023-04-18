package com.test.sicredi.votingservice.domains.voting.inputs

import com.test.sicredi.votingservice.common.enums.Roles
import java.time.LocalDateTime

data class RegisterVoteInput(
    val userName: String,
    val votingSessionCode: String,
    val votedField: String,
    val userRoles: List<Roles>,
    val instant: LocalDateTime
)