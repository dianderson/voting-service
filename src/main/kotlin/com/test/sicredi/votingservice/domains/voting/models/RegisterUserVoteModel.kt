package com.test.sicredi.votingservice.domains.voting.models

data class RegisterUserVoteModel(
    val votingSessionCode: String,
    val votingField: String,
    val userName: String
)
