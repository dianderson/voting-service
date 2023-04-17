package com.test.sicredi.votingservice.domains.voting_session.resources

import com.test.sicredi.votingservice.domains.voting_session.inputs.CreateVotingSessionInput
import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel

interface CreateVotingSession {
    fun execute(input: CreateVotingSessionInput): VotingSessionModel?
}