package com.test.sicredi.votingservice.infraestructure.db.models

import com.test.sicredi.votingservice.common.enums.Roles
import java.time.LocalDateTime

data class DbVotingSessionModel(
    val id: String,
    val agenda: DbAgendaModel,
    val startTime: LocalDateTime,
    val durationInMinutes: Long,
    val endTime: LocalDateTime,
    val allowedRoles: List<Roles>,
    val isSingleVote: Boolean,
    val fields: List<DbVotingFieldsModel>,
    val createdAt: LocalDateTime,
    val createdBy: String,
    val updatedAt: LocalDateTime,
    val updatedBy: String
)
