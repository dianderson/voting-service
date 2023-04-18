package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionPreviewModel
import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.VotingSessionEntity
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.VotingFieldsRepository
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.VotingSessionRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.DbRegisterVote
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DbRegisterVoteImpl(
    private val votingFieldsRepository: VotingFieldsRepository
) : DbRegisterVote {
    override fun execute(votingSessionCode: String, votingField: String) {
        votingFieldsRepository.registerVote(votingSessionCode, votingField)
    }
}