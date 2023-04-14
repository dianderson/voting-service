package com.test.sicredi.votingservice.api.v1.requests

import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class CreateVotingSessionRequest(
    @field:NotBlank
    val agendaCode: String?,
    @field:NotNull
    @field:FutureOrPresent
    val startDate: LocalDateTime?,
    @field:NotNull
    @field:Min(1)
    val durationInMinutes: Long? = 1,
    @field:NotEmpty
    val allowedRoles: List<VotingRolesRequest>? = listOf(VotingRolesRequest.USER)
)
