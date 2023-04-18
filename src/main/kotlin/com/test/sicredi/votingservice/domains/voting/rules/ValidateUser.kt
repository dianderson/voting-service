package com.test.sicredi.votingservice.domains.voting.rules

import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import com.test.sicredi.votingservice.domains.voting.ports.VotingPort
import org.springframework.stereotype.Component
import javax.management.BadAttributeValueExpException

@Component
class ValidateUser(
    private val votingPort: VotingPort
) : HasVoteProcessingValidation {
    override fun execute(input: ProcessVoteInput, model: DomainVotingVotingSessionModel) {
        input.takeIf { votingPort.validateUserByUserName(it.userName) }
            ?: throw BadAttributeValueExpException("User name not valid")
    }
}