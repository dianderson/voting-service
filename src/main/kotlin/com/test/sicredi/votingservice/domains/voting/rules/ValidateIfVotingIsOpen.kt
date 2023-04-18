package com.test.sicredi.votingservice.domains.voting.rules

import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import org.springframework.stereotype.Component
import javax.management.BadAttributeValueExpException

@Component
class ValidateIfVotingIsOpen : HasVoteProcessingValidation {
    override fun execute(input: ProcessVoteInput, model: DomainVotingVotingSessionModel) {
        model.startTime.plusMinutes(model.durationInMinutes)
            .takeIf { input.instant.isAfter(model.startTime) && input.instant.isBefore(it) }
            ?: throw BadAttributeValueExpException("Voting time outside authorized range")
    }
}