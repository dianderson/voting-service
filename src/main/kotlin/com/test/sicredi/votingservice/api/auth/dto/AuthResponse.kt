package com.test.sicredi.votingservice.api.auth.dto

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
    val userName: String,
    val avatarUrl: String?,
    val roles: List<String>
)
