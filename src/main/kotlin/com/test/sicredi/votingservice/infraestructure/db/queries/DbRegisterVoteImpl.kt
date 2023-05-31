package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.VotingFieldsRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.DbRegisterVote
import org.springframework.stereotype.Component

@Component
class DbRegisterVoteImpl(
    private val votingFieldsRepository: VotingFieldsRepository
) : DbRegisterVote {
    override fun execute(votingSessionCode: String, votingField: String) {
        votingFieldsRepository.registerVote(votingSessionCode, votingField)
    }
}