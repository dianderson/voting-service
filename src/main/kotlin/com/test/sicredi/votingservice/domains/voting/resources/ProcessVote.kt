package com.test.sicredi.votingservice.domains.voting.resources

import com.test.sicredi.votingservice.domains.voting.inputs.ProcessVoteInput

interface ProcessVote {
    fun execute(input: ProcessVoteInput)
}