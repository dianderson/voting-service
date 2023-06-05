package com.test.sicredi.votingservice.infraestructure.db.postgres.entities

import com.test.sicredi.votingservice.api.v1.dto.requests.VotingRolesRequest
import com.test.sicredi.votingservice.common.enums.Roles
import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateVotingSessionInput
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
    @field:Column(name = "end_time", nullable = false)
    val endTime: LocalDateTime,
    @field:Column(name = "allowed_roles", nullable = false)
    val allowedRoles: String,
    @field:Column(name = "is_single_vote", nullable = false)
    val isSingleVote: Boolean,
    @field:Column(name = "notified", nullable = false)
    val notified: Boolean,
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
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "id_agenda", nullable = false)
    val agenda: AgendaEntity
) {
    @OneToMany(mappedBy = "votingSession", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var votingSessionFields: List<VotingFieldsEntity>? = null

    constructor(input: DbCreateVotingSessionInput, agenda: AgendaEntity) : this(
        id = input.id,
        agenda = agenda,
        startTime = input.startTime,
        endTime = input.startTime.plusMinutes(input.durationInMinutes),
        durationInMinutes = input.durationInMinutes,
        allowedRoles = input.allowedRoles.buildString(),
        isSingleVote = input.isSingleVote,
        notified = false
    ) {
        votingSessionFields = input.votingFields.map {
            VotingFieldsEntity(it, this)
        }
    }

    fun toModel() = DbVotingSessionModel(
        id = id,
        agenda = agenda.toModel(),
        startTime = startTime,
        durationInMinutes = durationInMinutes,
        endTime = endTime,
        allowedRoles = allowedRoles.split(",").map { Roles.valueOf(it) },
        isSingleVote = isSingleVote,
        fields = votingSessionFields!!.map { it.toModel() },
        createdAt = createdAt!!,
        createdBy = createdBy!!,
        updatedAt = updatedAt!!,
        updatedBy = updatedBy!!
    )

    companion object {
        private fun List<VotingRolesRequest>.buildString() = this.map { it.name }.reduce { a, b -> "$a,$b" }
    }
}
