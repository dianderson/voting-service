package com.test.sicredi.votingservice.infraestructure.db.inputs

import com.test.sicredi.votingservice.api.v1.requests.VotingRolesRequest
import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.VotingSessionEntity
import java.time.LocalDateTime

data class DbCreateVotingSessionInput(
    val id: String,
    val agendaCode: String,
    val startTime: LocalDateTime,
    val durationInMinutes: Long,
    val allowedRoles: List<VotingRolesRequest>
) {
    fun toEntity() = VotingSessionEntity(
        id = id,
        agendaCode = agendaCode,
        startTime = startTime,
        durationInMinutes = durationInMinutes,
        allowedRoles = allowedRoles.buildString()
    )

    private fun List<VotingRolesRequest>.buildString() = this.map { it.name }.reduce { a, b -> "$a,$b" }
}
