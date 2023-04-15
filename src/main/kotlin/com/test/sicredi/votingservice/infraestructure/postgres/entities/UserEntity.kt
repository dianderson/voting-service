package com.test.sicredi.votingservice.infraestructure.postgres.entities

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @field:Id
    @field:Column(name = "id")
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @field:Column(name = "user_name", nullable = false)
    val email: String,
    @field:Column(name = "password", nullable = false)
    val password: String,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "id_user")],
        inverseJoinColumns = [JoinColumn(name = "id_role")]
    )
    val roles: Set<RoleEntity>
)
