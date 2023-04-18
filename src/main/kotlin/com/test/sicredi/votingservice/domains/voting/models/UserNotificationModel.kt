package com.test.sicredi.votingservice.domains.voting.models

data class UserNotificationModel(
    val userName: String,
    val responseStatus: ResponseStatus,
    val error: String? = null
)