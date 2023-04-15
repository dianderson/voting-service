package com.test.sicredi.votingservice.infraestructure.postgres.entities

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "agenda")
@EntityListeners(AuditingEntityListener::class)
data class VotingSessionEntity(
    @field:Id
    @field:Column(name = "id")
    val id: String,
    @field:Column(name = "start_date", nullable = false)
    val startDate: LocalDateTime,
    @field:Column(name = "duration_in_minutes", nullable = false)
    val durationInMinutes: Long,
    @field:Column(name = "allowed_roles", nullable = false)
    val allowedRoles: String,
    @field:CreatedDate
    @field:Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null,
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    var createdBy: String? = null,
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime? = null,
    @LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    var updatedBy: String? = null,
    @field:Column(name = "id_agenda", nullable = false)
    @field:ManyToOne
    val agenda: AgendaEntity //TODO Fazer tabela de relacionamento
)
