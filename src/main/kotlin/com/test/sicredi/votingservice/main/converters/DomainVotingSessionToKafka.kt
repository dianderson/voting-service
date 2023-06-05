package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.domains.voting_session.models.VotingSessionModel
import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaVotingFieldsModel
import com.test.sicredi.votingservice.infraestructure.kafka.models.KafkaVotingResultModel

fun VotingSessionModel.toKafkaVotingResultModel() = KafkaVotingResultModel(
    code = code,
    agendaCode = agenda.code,
    startTime = startTime,
    durationInMinutes = durationInMinutes,
    endTime = endTime,
    allowedRoles = allowedRoles,
    fields = fields.map { KafkaVotingFieldsModel(it.name, it.quantity) },
    isSingleVote = isSingleVote
)