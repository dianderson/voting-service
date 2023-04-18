package com.test.sicredi.votingservice.main.converters

import com.test.sicredi.votingservice.domains.voting.models.DomainVotingVotingSessionModel
import com.test.sicredi.votingservice.domains.voting.models.FieldPreviewModel
import com.test.sicredi.votingservice.domains.voting.models.VotingSessionPreviewModel
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingFieldsModel
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionPreviewModel

fun DbVotingSessionModel.toDomainVotingVotingSessionModel() = DomainVotingVotingSessionModel(
    startTime = startTime,
    durationInMinutes = durationInMinutes,
    allowedRoles = allowedRoles,
    votingFields = fields.map { it.name }
)

fun DbVotingSessionPreviewModel.toVotingSessionPreviewModel() = VotingSessionPreviewModel(
    votingSessionCode = votingSessionCode,
    timeLeftInMinutes = timeLeftInMinutes,
    fieldPreview = fieldPreview.map { it.toFieldPreviewModel() }
)

private fun DbVotingFieldsModel.toFieldPreviewModel() = FieldPreviewModel(
    fieldName = name,
    quantity = quantity
)