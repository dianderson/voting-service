package com.test.sicredi.votingservice.api.v1.ports

import com.test.sicredi.votingservice.api.v1.requests.CreateAgendaRequest
import com.test.sicredi.votingservice.api.v1.requests.CreateVotingSessionRequest
import com.test.sicredi.votingservice.api.v1.requests.VoteRequest
import com.test.sicredi.votingservice.api.v1.responses.AgendaResponse
import com.test.sicredi.votingservice.api.v1.responses.VotingSessionResponse

interface ApiV1Port {
    fun createAgenda(request: CreateAgendaRequest): AgendaResponse
    fun createVotingSession(request: CreateVotingSessionRequest): VotingSessionResponse
    fun registerVote(request: VoteRequest)
}