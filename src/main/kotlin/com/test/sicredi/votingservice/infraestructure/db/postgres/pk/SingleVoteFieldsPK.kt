package com.test.sicredi.votingservice.infraestructure.db.postgres.pk

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class SingleVoteFieldsPK(
    @field:Column(name = "id_voting_session")
    val votingSessionId: String,
    @field:Column(name = "user_name")
    val userName: String
) : Serializable {
    companion object {
        const val serialVersionUID = -557755813582894641L
    }
}
