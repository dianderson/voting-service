package com.test.sicredi.votingservice.domains.voting.fixtures

import com.test.sicredi.votingservice.common.enums.Roles
import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput
import java.time.LocalDateTime
import java.util.*

class ProcessVoteInputFixture private constructor() {
    companion object {
        fun newProcessVoteInput(
            userName: String = "User name",
            votingSessionCode: String = UUID.randomUUID().toString(),
            votedField: String = "Yes",
            userRoles: List<Roles> = listOf(Roles.USER),
            instant: LocalDateTime = LocalDateTime.now()
        ) = ProcessVoteInput(
            userName = userName,
            votingSessionCode = votingSessionCode,
            votedField = votedField,
            userRoles = userRoles,
            instant = instant
        )
    }
}
