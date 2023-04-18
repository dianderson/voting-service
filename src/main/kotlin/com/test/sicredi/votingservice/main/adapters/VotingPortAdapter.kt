package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import com.test.sicredi.votingservice.domains.voting.models.UserNotificationModel
import com.test.sicredi.votingservice.domains.voting.models.VotingSessionPreviewModel
import com.test.sicredi.votingservice.domains.voting.ports.VotingPort
import com.test.sicredi.votingservice.infraestructure.db.resources.DbFindVotingSessionByCode
import com.test.sicredi.votingservice.infraestructure.db.resources.DbRegisterVote
import com.test.sicredi.votingservice.infraestructure.kafka.resources.PublishVotingRegistration
import com.test.sicredi.votingservice.main.converters.toDomainVotingVotingSessionModel
import com.test.sicredi.votingservice.main.converters.toKafkaRegisterVotingModel
import com.test.sicredi.votingservice.main.converters.toVotingSessionPreviewModel
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Component

@Component
class VotingPortAdapter(
    private val publishVotingRegistration: PublishVotingRegistration,
    private val findVotingSessionByCode: DbFindVotingSessionByCode,
    private val registerVote: DbRegisterVote
) : VotingPort {
    private val logger = LogManager.getLogger(VotingPortAdapter::class.java)
    override fun sendToProcessing(input: RegisterVoteInput) {
        publishVotingRegistration.execute(input.toKafkaRegisterVotingModel())
    }

    override fun findVotingSessionByCode(votingSessionCode: String): DomainVotingVotingSessionModel? =
        findVotingSessionByCode.execute(votingSessionCode)?.toDomainVotingVotingSessionModel()

    override fun registerVote(votingSessionCode: String, votingField: String): VotingSessionPreviewModel =
        registerVote.execute(votingSessionCode, votingField).toVotingSessionPreviewModel()

    override fun notifyUser(model: UserNotificationModel) {
        logger.info(model)
    }

    override fun notifyTheVotePreview(model: VotingSessionPreviewModel) {
        logger.info(model)
    }
}