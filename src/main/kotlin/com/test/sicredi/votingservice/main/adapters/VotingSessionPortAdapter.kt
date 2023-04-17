package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.domains.voting_session.inputs.CreateVotingSessionInput
import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel
import com.test.sicredi.votingservice.domains.voting_session.ports.VotingSessionPort
import com.test.sicredi.votingservice.infraestructure.db.resources.DbCreateVotingSession
import com.test.sicredi.votingservice.main.converters.toDbCreateVotingSessionInput
import com.test.sicredi.votingservice.main.converters.toVotingSessionModel
import org.springframework.stereotype.Component

@Component
class VotingSessionPortAdapter(
    private val createVotingSession: DbCreateVotingSession
) : VotingSessionPort {
    override fun createVotingSession(input: CreateVotingSessionInput): VotingSessionModel =
        createVotingSession.execute(
            input.toDbCreateVotingSessionInput()
        ).toVotingSessionModel()
}