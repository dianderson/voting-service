package com.test.sicredi.votingservice.domains.voting.ports

import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import com.test.sicredi.votingservice.domains.voting.models.RegisterUserVoteModel
import com.test.sicredi.votingservice.domains.voting.models.UserNotificationModel
import com.test.sicredi.votingservice.domains.voting.models.VotingSessionPreviewModel

interface VotingPort {
    fun sendToProcessing(input: RegisterVoteInput)
    fun findVotingSessionByCode(votingSessionCode: String): DomainVotingVotingSessionModel?
    fun registerVote(votingSessionCode: String, votingField: String)
    fun registerUserVote(model: RegisterUserVoteModel)
    fun notifyUser(model: UserNotificationModel)
    fun notifyTheVotePreview(model: VotingSessionPreviewModel)
}