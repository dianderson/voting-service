package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.VotingSessionRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.DbFindVotingSessionByCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class DbFindVotingSessionByCodeImpl(
    private val votingSessionRepository: VotingSessionRepository
) : DbFindVotingSessionByCode {
    override fun execute(votingSessionCode: String): DbVotingSessionModel? =
        votingSessionRepository.findByIdOrNull(votingSessionCode)?.toModel()
}