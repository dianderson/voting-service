package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.domains.voting_session.inputs.CreateVotingSessionInput
import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel
import com.test.sicredi.votingservice.domains.voting_session.ports.VotingSessionPort
import com.test.sicredi.votingservice.infraestructure.db.resources.DbCreateVotingSession
import com.test.sicredi.votingservice.infraestructure.db.resources.DbFindAllClosedVotingSession
import com.test.sicredi.votingservice.infraestructure.kafka.resources.PublishVotingResult
import com.test.sicredi.votingservice.main.converters.toDbCreateVotingSessionInput
import com.test.sicredi.votingservice.main.converters.toKafkaVotingResultModel
import com.test.sicredi.votingservice.main.converters.toVotingSessionModel
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class VotingSessionPortAdapter(
    private val publishVotingResult: PublishVotingResult,
    private val createVotingSession: DbCreateVotingSession,
    private val findAllClosedVotingSession: DbFindAllClosedVotingSession
) : VotingSessionPort {
    override fun createVotingSession(input: CreateVotingSessionInput): VotingSessionModel =
        createVotingSession.execute(
            input.toDbCreateVotingSessionInput()
        ).toVotingSessionModel()

    override fun findAllClosedVotingSession(now: LocalDateTime): List<VotingSessionModel> =
        findAllClosedVotingSession.execute(now).map { it.toVotingSessionModel() }

    override fun notifyVotingResult(votingSessionModel: VotingSessionModel) {
        publishVotingResult.execute(votingSessionModel.toKafkaVotingResultModel())
    }
}