package com.test.sicredi.votingservice.infraestructure.postgres.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "refresh_token")
data class RefreshTokenEntity(
    @field:Id
    @field:Column(name = "user_name")
    val userName: String,
    @field:Column(name = "refresh_token", nullable = false)
    val refreshToken: String,
    @field:Column(name = "expires_at", nullable = false)
    val expiresAt: LocalDateTime,
    @field:OneToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "id_user", nullable = false)
    val user: UserEntity
)
