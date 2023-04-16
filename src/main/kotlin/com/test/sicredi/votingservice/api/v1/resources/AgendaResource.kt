package com.test.sicredi.votingservice.api.v1.resources

import com.test.sicredi.votingservice.api.auth.models.UserSecurity
import com.test.sicredi.votingservice.api.v1.ports.ApiV1Port
import com.test.sicredi.votingservice.api.v1.requests.CreateAgendaRequest
import jakarta.validation.Valid
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
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
        @AuthenticationPrincipal userLogged: UserSecurity,
        @RequestBody @Valid request: CreateAgendaRequest
    ) = apiV1Port.createAgenda(request)
}