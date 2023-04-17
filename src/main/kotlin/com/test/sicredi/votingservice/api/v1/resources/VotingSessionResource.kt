package com.test.sicredi.votingservice.api.v1.resources

import com.test.sicredi.votingservice.api.v1.ports.ApiV1Port
import com.test.sicredi.votingservice.api.v1.requests.CreateVotingSessionRequest
import jakarta.validation.Valid
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/voting-sessions")
@PreAuthorize("hasAnyAuthority('ADMIN','MASTER')")
class VotingSessionResource(
    private val apiV1Port: ApiV1Port
) {
    @PostMapping
    fun createVotingSession(
        @RequestBody @Valid request: CreateVotingSessionRequest
    ) = apiV1Port.createVotingSession(request)
}