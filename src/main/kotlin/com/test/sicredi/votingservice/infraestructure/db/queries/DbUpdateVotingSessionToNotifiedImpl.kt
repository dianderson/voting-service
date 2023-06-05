package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.VotingSessionRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.DbUpdateVotingSessionToNotified
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class DbUpdateVotingSessionToNotifiedImpl(
    private val votingSessionRepository: VotingSessionRepository
) : DbUpdateVotingSessionToNotified {
    @Transactional
    override fun execute(votingSessionCode: String) {
        votingSessionRepository.updateToNotified(votingSessionCode)
    }
}