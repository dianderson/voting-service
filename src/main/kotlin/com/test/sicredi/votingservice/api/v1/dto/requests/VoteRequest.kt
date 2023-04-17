package com.test.sicredi.votingservice.api.v1.dto.requests

import jakarta.validation.constraints.NotBlank

data class VoteRequest(
    @field:NotBlank
    val field: String
)
