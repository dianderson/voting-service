package com.test.sicredi.votingservice.infraestructure.db.postgres.entities

import com.test.sicredi.votingservice.infraestructure.db.postgres.pk.VotingFieldsPK
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "voting_fields")
@EntityListeners(AuditingEntityListener::class)
data class VotingFieldsEntity(
    @field:EmbeddedId
    var fieldId: VotingFieldsPK,
    @field:Column(name = "field_name", insertable = false, updatable = false)
    val name: String,
    @field:Column(name = "quantity")
    val quantity: Long,
    @field:ManyToOne
    @field:JoinColumn(name = "id_voting_session", insertable = false, updatable = false)
    val votingSession: VotingSessionEntity
) {
    constructor(name: String, votingSession: VotingSessionEntity) : this(
        fieldId = VotingFieldsPK(votingSessionId = votingSession.id, fieldName = name),
        name = name,
        quantity = 0,
        votingSession = votingSession
    )
}
