package com.test.sicredi.votingservice.api.v1.requests

import jakarta.validation.constraints.*
import java.time.LocalDateTime

data class CreateVotingSessionRequest(
    @field:NotBlank
    val agendaCode: String?,
    @field:NotNull
    @field:FutureOrPresent
    val startTime: LocalDateTime?,
    @field:NotNull
    @field:Min(1)
    val durationInMinutes: Long? = 1,
    @field:NotEmpty
    val allowedRoles: List<VotingRolesRequest>? = listOf(VotingRolesRequest.USER)
)
