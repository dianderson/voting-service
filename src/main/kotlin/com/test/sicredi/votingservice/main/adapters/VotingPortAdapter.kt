package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import com.test.sicredi.votingservice.domains.voting.ports.VotingPort
import org.springframework.stereotype.Component

@Component
class VotingPortAdapter : VotingPort {
    override fun sendToProcessing(input: RegisterVoteInput) {
        TODO("Not yet implemented")
    }

    override fun findVotingSessionByCode(votingSessionCode: String): DomainVotingVotingSessionModel {
        TODO("Not yet implemented")
    }
}