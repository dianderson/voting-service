package com.test.sicredi.votingservice.api.v1.resources

import com.test.sicredi.votingservice.api.auth.models.UserSecurity
import com.test.sicredi.votingservice.api.v1.dto.requests.VoteRegister
import com.test.sicredi.votingservice.api.v1.dto.requests.VoteRequest
import com.test.sicredi.votingservice.api.v1.ports.ApiV1Port
import com.test.sicredi.votingservice.common.enums.Roles
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/v1/voting-sessions")
@PreAuthorize("hasAnyAuthority('USER','ADMIN','MASTER')")
class VotingResource(
    private val apiV1Port: ApiV1Port
) {
    @PostMapping("/{voting-session-code}/votes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun registerVote(
        @RequestBody @Valid request: VoteRequest,
        @AuthenticationPrincipal userLogged: UserSecurity,
        @PathVariable("voting-session-code") votingSessionCode: String
    ) {
        VoteRegister(
            userName = userLogged.userName,
            votingSessionCode = votingSessionCode,
            votedField = request.field,
            userRoles = userLogged.roles.map { Roles.valueOf(it.authority) },
            instant = LocalDateTime.now()
        ).let { apiV1Port.registerVote(it) }
    }
}