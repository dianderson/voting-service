package com.test.sicredi.votingservice.infraestructure.db.resources

import com.test.sicredi.votingservice.infraestructure.db.inputs.DbRegisterUserVoteInput

interface DbRegisterUserVote {
    fun execute(input: DbRegisterUserVoteInput)
}