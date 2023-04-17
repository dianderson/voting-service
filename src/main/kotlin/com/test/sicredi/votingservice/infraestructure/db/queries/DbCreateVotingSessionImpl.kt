package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateVotingSessionInput
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel
import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.AgendaEntity
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.AgendaRepository
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.VotingSessionRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.DbCreateVotingSession
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class DbCreateVotingSessionImpl(
    private val agendaRepository: AgendaRepository,
    private val votingSessionRepository: VotingSessionRepository
) : DbCreateVotingSession {
    @Transactional
    override fun execute(input: DbCreateVotingSessionInput): DbVotingSessionModel = (
            votingSessionRepository.findByAgendaIdAndStartTime(input.agendaCode, input.startTime)
                ?: votingSessionRepository.save(input.toEntity(findAgendaById(input.agendaCode)))
            ).toModel()

    private fun findAgendaById(agendaId: String): AgendaEntity =
        agendaRepository.findByIdOrNull(agendaId)
            ?: throw EntityNotFoundException("Agenda not found")
}