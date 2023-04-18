package com.test.sicredi.votingservice.domains.voting.rules

import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import org.springframework.stereotype.Component
import javax.management.BadAttributeValueExpException

@Component
class ValidateIfTheFieldIsRight : HasVoteProcessingValidation {
    override fun execute(input: ProcessVoteInput, model: DomainVotingVotingSessionModel) {
        model.votingFields.takeIf { it.contains(input.votedField) }
            ?: throw BadAttributeValueExpException("Field ${input.votedField} not exist")
    }
}