package com.test.sicredi.votingservice.infraestructure.db.models

data class DbVotingSessionPreviewModel(
    val votingSessionCode: String,
    val timeLeftInMinutes: Long,
    val fieldPreview: List<DbVotingFieldsModel>
)