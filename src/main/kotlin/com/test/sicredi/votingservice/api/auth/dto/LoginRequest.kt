package com.test.sicredi.votingservice.api.auth.dto

data class LoginRequest(
    val email: String,
    val password: String
)
