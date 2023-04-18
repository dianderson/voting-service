package com.test.sicredi.votingservice.infraestructure.db.resources

import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel

interface DbFindVotingSessionByCode {
    fun execute(votingSessionCode: String): DbVotingSessionModel?
}