package com.test.sicredi.votingservice.infraestructure.db.postgres.entities

import com.test.sicredi.votingservice.infraestructure.db.postgres.pk.SingleVoteFieldsPK
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "single_vote_fields")
data class SingleVoteFieldsEntity(
    @field:EmbeddedId
    var id: SingleVoteFieldsPK,
    @field:Column(name = "field_name")
    val fieldVoted: String
)