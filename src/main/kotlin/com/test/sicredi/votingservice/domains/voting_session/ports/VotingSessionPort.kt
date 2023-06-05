package com.test.sicredi.votingservice.domains.voting_session.ports

import com.test.sicredi.votingservice.domains.voting_session.inputs.CreateVotingSessionInput
import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel
import java.time.LocalDateTime

interface VotingSessionPort {
    fun createVotingSession(input: CreateVotingSessionInput): VotingSessionModel
    fun findAllClosedVotingSession(now: LocalDateTime): List<VotingSessionModel>
    fun notifyVotingResult(votingSessionModel: VotingSessionModel)
    fun updateToNotified(code: String)
}