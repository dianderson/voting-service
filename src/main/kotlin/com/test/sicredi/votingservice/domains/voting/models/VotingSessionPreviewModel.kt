package com.test.sicredi.votingservice.domains.voting.models

data class VotingSessionPreviewModel(
    val votingSessionCode: String,
    val timeLeftInMinutes: Long,
    val fieldPreview: List<FieldPreviewModel>
)
