package com.test.sicredi.votingservice.infraestructure.db.resources

interface DbRegisterVote {
    fun execute(votingSessionCode: String, votingField: String)
}