package com.test.sicredi.votingservice.infraestructure.db.inputs

import com.test.sicredi.votingservice.api.v1.dto.requests.VotingRolesRequest
import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.AgendaEntity
import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.VotingSessionEntity
import java.time.LocalDateTime

data class DbCreateVotingSessionInput(
    val id: String,
    val agendaCode: String,
    val startTime: LocalDateTime,
    val durationInMinutes: Long,
    val allowedRoles: List<VotingRolesRequest>,
    val votingFields: List<String>
) {
    fun toEntity(entity: AgendaEntity) = VotingSessionEntity(
        input = this,
        agenda = entity
    )
}
