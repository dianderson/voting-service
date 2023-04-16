package com.test.sicredi.votingservice.api.auth.services

import com.test.sicredi.votingservice.api.auth.dto.AuthResponse
import com.test.sicredi.votingservice.api.auth.dto.LoginRequest
import com.test.sicredi.votingservice.api.auth.models.UserSecurity
import com.test.sicredi.votingservice.infraestructure.db.resources.FindUserByUserName
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.oauth2.jwt.*
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class AuthService(
    private val jwtEncoder: JwtEncoder,
    private val jwtDecoder: JwtDecoder,
    private val findUserByUserName: FindUserByUserName
) {
    fun signIn(request: LoginRequest): AuthResponse {
        val user = findUserByUserName.execute(request.email)
            ?.takeIf { request.password == it.password }
            ?: throw AuthenticationServiceException("Login failed")

        val accessToken = UserSecurity(
            id = user.id,
            userName = user.email,
            roles = user.roles.map { it.name }.reduce { a, b -> "$a,$b" }
        ).buildToken()

        return AuthResponse(
            accessToken = accessToken,
            refreshToken = UUID.randomUUID().toString(),
            userName = user.email,
            avatarUrl = null,
            roles = user.roles.map { it.name }
        )
    }

    private fun UserSecurity.buildToken(): String {
        val jwsHeader = JwsHeader.with { "HS256" }.build()
        val claims = JwtClaimsSet.builder()
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plusSeconds(3600))
            .subject(this.userName)
            .claim("id", this.id)
            .claim("roles", this.roles.map { it.authority }.reduce { a, b -> "$a,$b" })
            .build()
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).tokenValue
    }

    fun parseToken(token: String): UserSecurity? {
        return try {
            val jwt = jwtDecoder.decode(token)
            UserSecurity(
                id = jwt.claims["id"] as Long,
                userName = jwt.subject,
                roles = jwt.claims["roles"] as String
            )
        } catch (e: Exception) {
            null
        }
    }
}