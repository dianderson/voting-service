package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.domains.voting.resources.ProcessVote
import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaRegisterVotingModel
import com.test.sicredi.votingservice.infraestructure.kafka.port.KafkaPort
import com.test.sicredi.votingservice.main.converters.toProcessVoteInput
import org.springframework.stereotype.Component

@Component
class KafkaPortAdapter(
    private val processVote: ProcessVote
) : KafkaPort {
    override fun processVoteRegistration(event: KafkaRegisterVotingModel) {
        processVote.execute(event.toProcessVoteInput())
    }
}