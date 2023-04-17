package com.test.sicredi.votingservice.domains.voting.use_cases

import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput
import com.test.sicredi.votingservice.domains.voting.ports.VotingPort
import com.test.sicredi.votingservice.domains.voting.resources.RegisterVote
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class RegisterVoteImpl(
    private val votingPort: VotingPort
) : RegisterVote {
    @Async
    override fun execute(input: RegisterVoteInput) {
        votingPort.sendToProcessing(input)
    }
}