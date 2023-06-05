package com.test.sicredi.votingservice.infraestructure.db.resources

import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionModel
import java.time.LocalDateTime

interface DbFindAllClosedVotingSession {
    fun execute(now: LocalDateTime): List<DbVotingSessionModel>
}