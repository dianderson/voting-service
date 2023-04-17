package com.test.sicredi.votingservice.domains.voting_session.use_cases

import com.test.sicredi.votingservice.domains.voting_session.inputs.CreateVotingSessionInput
import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel
import com.test.sicredi.votingservice.domains.voting_session.ports.VotingSessionPort
import com.test.sicredi.votingservice.domains.voting_session.resources.CreateVotingSession
import org.springframework.stereotype.Service

@Service
class CreateVotingSessionImpl(
    private val votingSessionPort: VotingSessionPort
) : CreateVotingSession {
    override fun execute(input: CreateVotingSessionInput): VotingSessionModel? =
        votingSessionPort.createVotingSession(input)
}