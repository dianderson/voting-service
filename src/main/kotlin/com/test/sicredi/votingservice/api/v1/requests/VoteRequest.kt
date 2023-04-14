package com.test.sicredi.votingservice.api.v1.requests

import jakarta.validation.constraints.NotNull

data class VoteRequest(
    @field:NotNull
    val yes: Boolean?
)
