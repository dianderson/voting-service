package com.test.sicredi.votingservice.api.v1.resources

import com.test.sicredi.votingservice.api.v1.ports.ApiV1Port
import com.test.sicredi.votingservice.api.v1.dto.requests.VoteRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/votes")
class VotingResource(
    private val apiV1Port: ApiV1Port
) {
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun registerVote(
        @RequestBody @Valid request: VoteRequest
    ) {
        apiV1Port.registerVote(request)
    }
}