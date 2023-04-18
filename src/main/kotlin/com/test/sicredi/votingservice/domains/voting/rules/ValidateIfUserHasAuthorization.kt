package com.test.sicredi.votingservice.domains.voting.rules

import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import org.springframework.stereotype.Component
import javax.management.BadAttributeValueExpException

@Component
class ValidateIfUserHasAuthorization : HasVoteProcessingValidation {
    override fun execute(input: ProcessVoteInput, model: DomainVotingVotingSessionModel) {
        input.userRoles.takeIf { role -> role.any { model.allowedRoles.contains(it) } }
            ?: throw BadAttributeValueExpException("No authorization to vote")
    }
}