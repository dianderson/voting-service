package com.test.sicredi.votingservice.api.v1.resources

import com.test.sicredi.votingservice.api.v1.dto.requests.CreateVotingSessionRequest
import com.test.sicredi.votingservice.api.v1.ports.ApiV1Port
import jakarta.validation.Valid
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/agenda/{agenda-code}/voting-sessions")
@PreAuthorize("hasAnyAuthority('ADMIN','MASTER')")
class VotingSessionResource(
    private val apiV1Port: ApiV1Port
) {
    @PostMapping
    fun createVotingSession(
        @RequestBody @Valid request: CreateVotingSessionRequest,
        @PathVariable("agenda-code") agendaCode: String
    ) = apiV1Port.createVotingSession(agendaCode, request)
}