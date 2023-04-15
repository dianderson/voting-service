package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateVotingSessionInput
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.AgendaRepository
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.VotingSessionRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.CreateVotingSession
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class CreateVotingSessionImpl(
    private val agendaRepository: AgendaRepository,
    private val votingSessionRepository: VotingSessionRepository
) : CreateVotingSession {
    override fun execute(input: DbCreateVotingSessionInput): DbVotingSessionModel =
        agendaRepository.findByIdOrNull(input.agendaCode)
            .let { it ?: throw EntityNotFoundException("Agenda nao encontrada") }
            .let { votingSessionRepository.save(input.toEntity(it)) }
            .toModel()
}