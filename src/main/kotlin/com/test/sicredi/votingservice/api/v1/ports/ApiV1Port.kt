package com.test.sicredi.votingservice.api.v1.ports

import com.test.sicredi.votingservice.api.v1.requests.CreateAgendaRequest
import com.test.sicredi.votingservice.api.v1.requests.CreateVotingSessionRequest
import com.test.sicredi.votingservice.api.v1.requests.VoteRequest
import com.test.sicredi.votingservice.api.v1.responses.CreateAgendaResponse
import com.test.sicredi.votingservice.api.v1.responses.CreateVotingSessionResponse

interface ApiV1Port {
    fun createAgenda(request: CreateAgendaRequest): CreateAgendaResponse
    fun createVotingSession(request: CreateVotingSessionRequest): CreateVotingSessionResponse
    fun registerVote(request: VoteRequest)
}