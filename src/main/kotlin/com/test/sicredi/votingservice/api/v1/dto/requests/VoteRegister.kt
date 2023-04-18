package com.test.sicredi.votingservice.api.v1.dto.requests

import com.test.sicredi.votingservice.common.enums.Roles
import java.time.LocalDateTime

data class VoteRegister(
    val votingSessionCode: String,
    val votedField: String,
    val userRoles: List<Roles>,
    val instant: LocalDateTime
)
