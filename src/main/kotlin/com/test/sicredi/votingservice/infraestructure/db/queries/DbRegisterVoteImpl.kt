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
    private val votingFieldsRepository: VotingFieldsRepository,
    private val votingSessionRepository: VotingSessionRepository
) : DbRegisterVote {
    override fun execute(votingSessionCode: String, votingField: String): DbVotingSessionPreviewModel =
        votingFieldsRepository.registerVote(votingSessionCode, votingField)
            .let { votingSessionRepository.findByIdOrNull(votingSessionCode) }
            ?.toDbVotingSessionPreviewModel()!!

    private fun VotingSessionEntity.toDbVotingSessionPreviewModel() = DbVotingSessionPreviewModel(
        votingSessionCode = id,
        timeLeftInMinutes = (startTime.minute + durationInMinutes).getTimeLeft(),
        fieldPreview = votingSessionFields!!.map { it.toModel() }
    )

    private fun Long.getTimeLeft(): Long =
        this.minus(LocalDateTime.now().minute)
}