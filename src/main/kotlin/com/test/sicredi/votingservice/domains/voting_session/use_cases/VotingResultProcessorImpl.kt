package com.test.sicredi.votingservice.domains.voting_session.use_cases

import com.test.sicredi.votingservice.domains.voting_session.ports.VotingSessionPort
import com.test.sicredi.votingservice.domains.voting_session.resources.VotingResultProcessor
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class VotingResultProcessorImpl(
    private val votingSessionPort: VotingSessionPort
) : VotingResultProcessor {
    override fun execute() {
        votingSessionPort.findAllClosedVotingSession(LocalDateTime.now())
            .forEach { votingSessionModel -> votingSessionPort.notifyVotingResult(votingSessionModel) }
    }
}