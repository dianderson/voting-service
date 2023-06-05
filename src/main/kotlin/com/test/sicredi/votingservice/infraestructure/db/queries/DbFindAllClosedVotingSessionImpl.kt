package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.VotingSessionRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.DbFindAllClosedVotingSession
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Component
class DbFindAllClosedVotingSessionImpl(
    private val votingSessionRepository: VotingSessionRepository
) : DbFindAllClosedVotingSession {
    @Transactional(readOnly = true)
    override fun execute(now: LocalDateTime): List<DbVotingSessionModel> =
        votingSessionRepository.findAllByNotifiedFalseAndEndTimeBefore(now)
            .map { it.toModel() }
}