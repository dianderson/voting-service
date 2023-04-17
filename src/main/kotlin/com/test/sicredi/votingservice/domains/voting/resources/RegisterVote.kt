package com.test.sicredi.votingservice.domains.voting.resources

import com.test.sicredi.votingservice.domains.voting.inputs.RegisterVoteInput

interface RegisterVote {
    fun execute(input: RegisterVoteInput)
}