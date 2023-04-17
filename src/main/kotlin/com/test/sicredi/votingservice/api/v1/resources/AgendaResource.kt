package com.test.sicredi.votingservice.api.v1.resources

import com.test.sicredi.votingservice.api.v1.ports.ApiV1Port
import com.test.sicredi.votingservice.api.v1.requests.CreateAgendaRequest
import com.test.sicredi.votingservice.api.v1.responses.AgendaResponse
import jakarta.validation.Valid
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/agenda")
@PreAuthorize("hasAnyAuthority('MASTER')")
class AgendaResource(
    private val apiV1Port: ApiV1Port
) {
    @PostMapping
    fun createAgenda(
        @RequestBody @Valid request: CreateAgendaRequest
    ): AgendaResponse = apiV1Port.createAgenda(request)
}