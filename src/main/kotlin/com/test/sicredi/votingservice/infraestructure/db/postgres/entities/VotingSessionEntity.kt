package com.test.sicredi.votingservice.infraestructure.db.postgres.entities

import com.test.sicredi.votingservice.common.enums.Roles
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "voting_sessions")
@EntityListeners(AuditingEntityListener::class)
data class VotingSessionEntity(
    @field:Id
    @field:Column(name = "id_voting_session")
    val id: String,
    @field:Column(name = "start_time", nullable = false)
    val startTime: LocalDateTime,
    @field:Column(name = "duration_in_minutes", nullable = false)
    val durationInMinutes: Long,
    @field:Column(name = "allowed_roles", nullable = false)
    val allowedRoles: String,
    @field:CreatedDate
    @field:Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null,
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    var createdBy: String? = "create test",
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime? = null,
    @LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    var updatedBy: String? = "update test",
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "id_agenda", nullable = false)
    val agenda: AgendaEntity
) {
    fun toModel() = DbVotingSessionModel(
        id = id,
        agenda = agenda.toModel(),
        startTime = startTime,
        durationInMinutes = durationInMinutes,
        allowedRoles = allowedRoles.split(",").map { Roles.valueOf(it) },
        createdAt = createdAt!!,
        createdBy = createdBy!!,
        updatedAt = updatedAt!!,
        updatedBy = updatedBy!!
    )
}
