package com.test.sicredi.votingservice.api.v1.requests

import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class CreateAgendaRequest(
    @field:NotBlank
    @field:Size(min = 3, max = 30)
    val name: String?,
    @field:NotBlank
    @field:Size(min = 3, max = 80)
    val subject: String?,
    @field:NotBlank
    @field:Size(min = 3, max = 250)
    val comments: String?,
    @field:NotNull
    @field:FutureOrPresent
    val startDate: LocalDateTime?,
    @field:NotNull
    @field:Min(1)
    val durationInHours: Long?
)
