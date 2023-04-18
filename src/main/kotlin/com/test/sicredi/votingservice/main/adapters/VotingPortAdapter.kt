package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput
import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import com.test.sicredi.votingservice.domains.voting.ports.VotingPort
import com.test.sicredi.votingservice.infraestructure.kafka.resources.PublishVotingRegistration
import com.test.sicredi.votingservice.main.converters.toKafkaRegisterVotingModel
import org.springframework.stereotype.Component

@Component
class VotingPortAdapter(
    private val publishVotingRegistration: PublishVotingRegistration
) : VotingPort {
    override fun sendToProcessing(input: RegisterVoteInput) {
        publishVotingRegistration.execute(input.toKafkaRegisterVotingModel())
    }

    override fun findVotingSessionByCode(votingSessionCode: String): DomainVotingVotingSessionModel {
        TODO("Not yet implemented")
    }
}