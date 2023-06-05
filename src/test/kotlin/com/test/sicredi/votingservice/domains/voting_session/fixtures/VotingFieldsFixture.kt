package com.test.sicredi.votingservice.domains.voting_session.fixtures

import com.test.sicredi.votingservice.domains.voting_session.models.VotingFieldsModel

class VotingFieldsFixture private constructor() {
    companion object {
        fun newVotingFields(
            name: String = "Field Name",
            quantity: Long = 0
        ) = VotingFieldsModel(
            name = name,
            quantity = quantity
        )
    }
}
