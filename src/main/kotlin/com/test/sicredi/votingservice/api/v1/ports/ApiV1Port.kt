package com.test.sicredi.votingservice.api.v1.ports

import com.test.sicredi.votingservice.api.v1.dto.requests.CreateAgendaRequest
import com.test.sicredi.votingservice.api.v1.dto.requests.CreateVotingSessionRequest
import com.test.sicredi.votingservice.api.v1.dto.requests.VoteRegister
import com.test.sicredi.votingservice.api.v1.dto.responses.AgendaResponse
import com.test.sicredi.votingservice.api.v1.dto.responses.VotingSessionResponse

interface ApiV1Port {
    fun createAgenda(request: CreateAgendaRequest): AgendaResponse
    fun createVotingSession(request: CreateVotingSessionRequest): VotingSessionResponse?
    fun registerVote(request: VoteRegister)
}