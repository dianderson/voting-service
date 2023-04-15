package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateVotingSessionInput
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.VotingSessionRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.CreateVotingSession
import org.springframework.stereotype.Component

@Component
class CreateVotingSessionImpl(
    private val votingSessionRepository: VotingSessionRepository
) : CreateVotingSession {
    override fun execute(input: DbCreateVotingSessionInput): DbVotingSessionModel =
        votingSessionRepository.save(input.toEntity()).toModel()
}