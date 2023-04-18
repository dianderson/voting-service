package com.test.sicredi.votingservice.domains.voting.use_cases

import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import com.test.sicredi.votingservice.domains.voting.models.RegisterUserVoteModel
import com.test.sicredi.votingservice.domains.voting.models.ResponseStatus
import com.test.sicredi.votingservice.domains.voting.models.UserNotificationModel
import com.test.sicredi.votingservice.domains.voting.ports.VotingPort
import com.test.sicredi.votingservice.domains.voting.resources.ProcessVote
import com.test.sicredi.votingservice.domains.voting.rules.HasVoteProcessingValidation
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProcessVoteImpl(
    private val votingPort: VotingPort,
    private val validates: List<HasVoteProcessingValidation>
) : ProcessVote {
    @Transactional
    override fun execute(input: ProcessVoteInput) {
        try {
            votingPort.findVotingSessionByCode(input.votingSessionCode)
                .let { it ?: throw EntityNotFoundException("Voting session ${input.votingSessionCode} not found") }
                .also { it.executeValidates(input) }
                .takeIf { it.isSingleVote }
                ?.let { input.registerUserVote() }
                .let { input.processCorrectVote() }
        } catch (ex: Exception) {
            UserNotificationModel(
                userName = input.userName,
                responseStatus = ResponseStatus.ERROR,
                error = ex.toString()
            ).let { votingPort.notifyUser(it) }
        }
    }

    private fun DomainVotingVotingSessionModel.executeValidates(input: ProcessVoteInput) {
        validates.map { it.execute(input, this) }
    }

    private fun ProcessVoteInput.registerUserVote() {
        RegisterUserVoteModel(
            votingSessionCode = votingSessionCode,
            votingField = votedField,
            userName = userName
        ).let { votingPort.registerUserVote(it) }
    }

    private fun ProcessVoteInput.processCorrectVote() {
        votingPort.registerVote(votingSessionCode, votedField)
        UserNotificationModel(
            responseStatus = ResponseStatus.SUCCESS,
            userName = userName
        ).let { votingPort.notifyUser(it) }
    }
}