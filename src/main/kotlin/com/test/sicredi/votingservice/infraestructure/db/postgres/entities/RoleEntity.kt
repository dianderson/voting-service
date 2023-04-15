package com.test.sicredi.votingservice.infraestructure.db.postgres.entities

import com.test.sicredi.votingservice.common.enums.Roles
import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class RoleEntity(
    @field:Id
    @field:Column(name = "id")
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @field:Enumerated(EnumType.STRING)
    @field:Column(name = "role", nullable = false)
    val role: Roles
)
