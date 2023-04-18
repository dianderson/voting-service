package com.test.sicredi.votingservice.domains.voting.fixtures

import com.test.sicredi.votingservice.common.enums.Roles
import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput
import java.time.LocalDateTime
import java.util.*

class RegisterVoteInputFixture private constructor() {
    companion object {
        fun newRegisterVoteInput(
            userName: String = "User name",
            votingSessionCode: String = UUID.randomUUID().toString(),
            votedField: String = "Yes",
            userRoles: List<Roles> = listOf(Roles.USER),
            instant: LocalDateTime = LocalDateTime.now()
        ) = RegisterVoteInput(
            userName = userName,
            votingSessionCode = votingSessionCode,
            votedField = votedField,
            userRoles = userRoles,
            instant = instant
        )
    }
}
