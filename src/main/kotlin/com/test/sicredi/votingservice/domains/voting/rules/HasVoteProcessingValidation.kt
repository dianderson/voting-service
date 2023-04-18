package com.test.sicredi.votingservice.domains.voting.rules

import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel

interface HasVoteProcessingValidation {
    fun execute(input: ProcessVoteInput, model: DomainVotingVotingSessionModel)
}