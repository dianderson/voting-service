package com.test.sicredi.votingservice.infraestructure.db.resources

interface DbUpdateVotingSessionToNotified {
    fun execute(votingSessionCode: String)
}