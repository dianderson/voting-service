package com.test.sicredi.votingservice.domains.voting_session.fixtures

import com.test.sicredi.votingservice.common.enums.Roles
import com.test.sicredi.votingservice.domains.agenda.fixtures.AgendaModelFixture
import com.test.sicredi.votingservice.domains.agenda.models.AgendaModel
import com.test.sicredi.votingservice.domains.voting_session.models.VotingFieldsModel
import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel
import java.time.LocalDateTime
import java.util.*

class VotingSessionModelFixture private constructor() {
    companion object {
        fun newVotingSessionModel(
            code: String = UUID.randomUUID().toString(),
            startTime: LocalDateTime = LocalDateTime.now(),
            agenda: AgendaModel = AgendaModelFixture.newAgendaModel(),
            durationInMinutes: Long = 1,
            endTime: LocalDateTime = startTime.plusMinutes(durationInMinutes),
            allowedRoles: List<Roles> = listOf(Roles.USER),
            fields: List<VotingFieldsModel> = listOf(VotingFieldsFixture.newVotingFields()),
            isSingleVote: Boolean = false,
            createdAt: LocalDateTime = LocalDateTime.now(),
            createdBy: String = "system",
            updatedAt: LocalDateTime = LocalDateTime.now(),
            updatedBy: String = "system"
        ) = VotingSessionModel(
            code = code,
            startTime = startTime,
            agenda = agenda,
            durationInMinutes = durationInMinutes,
            endTime = endTime,
            allowedRoles = allowedRoles,
            fields = fields,
            isSingleVote = isSingleVote,
            createdAt = createdAt,
            createdBy = createdBy,
            updatedAt = updatedAt,
            updatedBy = updatedBy
        )
    }
}
