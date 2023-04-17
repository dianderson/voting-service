package com.test.sicredi.votingservice.infraestructure.db.resources

import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateVotingSessionInput
import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel

interface DbCreateVotingSession {
    fun execute(input: DbCreateVotingSessionInput): DbVotingSessionModel
}