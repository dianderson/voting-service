package com.test.sicredi.votingservice.api.auth

import com.test.sicredi.votingservice.api.auth.dto.AuthResponse
import com.test.sicredi.votingservice.api.auth.dto.LoginRequest
import com.test.sicredi.votingservice.api.auth.services.AuthService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthResources(
    private val authService: AuthService
) {
    @PostMapping("/sign-in")
    fun signIn(
        @Valid @RequestBody request: LoginRequest
    ): AuthResponse = authService.signIn(request)
}