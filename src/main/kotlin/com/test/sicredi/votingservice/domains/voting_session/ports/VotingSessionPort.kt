package com.test.sicredi.votingservice.domains.voting_session.ports

import com.test.sicredi.votingservice.domains.voting_session.inputs.CreateVotingSessionInput
import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel

interface VotingSessionPort {
    fun createVotingSession(input: CreateVotingSessionInput): VotingSessionModel
}