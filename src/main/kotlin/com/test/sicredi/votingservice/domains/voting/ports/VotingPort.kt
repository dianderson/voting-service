package com.test.sicredi.votingservice.domains.voting.ports

import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel

interface VotingPort {
    fun sendToProcessing(input: RegisterVoteInput)
    fun findVotingSessionByCode(votingSessionCode: String): DomainVotingVotingSessionModel
}