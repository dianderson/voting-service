package com.test.sicredi.votingservice.domains.voting_session.models

import com.test.sicredi.votingservice.common.enums.Roles
import com.test.sicredi.votingservice.domains.agenda.models.AgendaModel
import java.time.LocalDateTime

data class VotingSessionModel(
    val code: String,
    val agenda: AgendaModel,
    val startTime: LocalDateTime,
    val durationInMinutes: Long,
    val allowedRoles: List<Roles>,
    val isSingleVote: Boolean,
    val createdAt: LocalDateTime,
    val createdBy: String,
    val updatedAt: LocalDateTime,
    val updatedBy: String
)