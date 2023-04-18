package com.test.sicredi.votingservice.domains.voting.use_cases

import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput
import com.test.sicredi.votingservice.domains.voting.models.*
import com.test.sicredi.votingservice.domains.voting.ports.VotingPort
import com.test.sicredi.votingservice.domains.voting.resources.ProcessVote
import com.test.sicredi.votingservice.domains.voting.rules.HasVoteProcessingValidation
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.prefs.Preferences

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
                .executeValidates(input)
            input.processCorrectVote()
        } catch (ex: Exception) {
            UserNotificationModel(
                userName = input.userName,
                responseStatus = ResponseStatus.ERROR,
                error = ex.toString()
            ).let { votingPort.notifyUser(it) }
        }
    }

    private fun DomainVotingVotingSessionModel.executeValidates(input: ProcessVoteInput) =
        validates.map { it.execute(input, this) }

    private fun ProcessVoteInput.processCorrectVote() {
        votingPort.registerVote(votingSessionCode, votedField)
            .sendNotifyTheVotePreview()
        sendUserNotification()
    }

    private fun VotingSessionPreviewModel.sendNotifyTheVotePreview() =
        VotingSessionPreviewModel(
            votingSessionCode = votingSessionCode,
            timeLeftInMinutes = timeLeftInMinutes,
            fieldPreview = fieldPreview
        ).let { votingPort.notifyTheVotePreview(it) }

    private fun ProcessVoteInput.sendUserNotification() =
        UserNotificationModel(
            responseStatus = ResponseStatus.SUCCESS,
            userName = userName
        ).let { votingPort.notifyUser(it) }
}