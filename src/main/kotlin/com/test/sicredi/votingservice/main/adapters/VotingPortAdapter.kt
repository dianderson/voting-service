package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import com.test.sicredi.votingservice.domains.voting.models.RegisterUserVoteModel
import com.test.sicredi.votingservice.domains.voting.models.UserNotificationModel
import com.test.sicredi.votingservice.domains.voting.models.VotingSessionPreviewModel
import com.test.sicredi.votingservice.domains.voting.ports.VotingPort
import com.test.sicredi.votingservice.infraestructure.clients.resources.ValidateUserByUserName
import com.test.sicredi.votingservice.infraestructure.db.resources.DbFindVotingSessionByCode
import com.test.sicredi.votingservice.infraestructure.db.resources.DbRegisterUserVote
import com.test.sicredi.votingservice.infraestructure.db.resources.DbRegisterVote
import com.test.sicredi.votingservice.infraestructure.kafka.resources.PublishVotingRegistration
import com.test.sicredi.votingservice.main.converters.toDbCreateAgendaInput
import com.test.sicredi.votingservice.main.converters.toDomainVotingVotingSessionModel
import com.test.sicredi.votingservice.main.converters.toKafkaRegisterVotingModel
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Component

@Component
class VotingPortAdapter(
    private val publishVotingRegistration: PublishVotingRegistration,
    private val findVotingSessionByCode: DbFindVotingSessionByCode,
    private val validateUserByUserName: ValidateUserByUserName,
    private val registerUserVote: DbRegisterUserVote,
    private val registerVote: DbRegisterVote
) : VotingPort {
    private val logger = LogManager.getLogger(VotingPortAdapter::class.java)
    override fun sendToProcessing(input: RegisterVoteInput) {
        publishVotingRegistration.execute(input.toKafkaRegisterVotingModel())
    }

    override fun findVotingSessionByCode(votingSessionCode: String): DomainVotingVotingSessionModel? =
        findVotingSessionByCode.execute(votingSessionCode)?.toDomainVotingVotingSessionModel()

    override fun validateUserByUserName(userName: String): Boolean =
        validateUserByUserName.execute(userName)

    override fun registerVote(votingSessionCode: String, votingField: String) {
        registerVote.execute(votingSessionCode, votingField)
    }

    override fun registerUserVote(model: RegisterUserVoteModel) {
        registerUserVote.execute(model.toDbCreateAgendaInput())
    }

    override fun notifyUser(model: UserNotificationModel) {
        logger.info(model)
    }

    override fun notifyTheVotePreview(model: VotingSessionPreviewModel) {
        logger.info(model)
    }
}