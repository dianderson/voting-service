package com.test.sicredi.votingservice.infraestructure.db.inputs

import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.SingleVoteFieldsEntity
import com.test.sicredi.votingservice.infraestructure.db.postgres.pk.SingleVoteFieldsPK

data class DbRegisterUserVoteInput(
    val votingSessionCode: String,
    val votingField: String,
    val userName: String
) {
    fun buildPk() = SingleVoteFieldsPK(
        votingSessionId = votingSessionCode,
        userName = userName
    )

    fun toEntity(pk: SingleVoteFieldsPK) = SingleVoteFieldsEntity(
        id = pk,
        fieldVoted = votingField
    )
}
