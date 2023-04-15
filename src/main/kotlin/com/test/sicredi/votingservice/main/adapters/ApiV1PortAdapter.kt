package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.api.v1.ports.ApiV1Port
import com.test.sicredi.votingservice.api.v1.requests.CreateAgendaRequest
import com.test.sicredi.votingservice.api.v1.requests.CreateVotingSessionRequest
import com.test.sicredi.votingservice.api.v1.requests.VoteRequest
import com.test.sicredi.votingservice.api.v1.responses.AgendaResponse
import com.test.sicredi.votingservice.api.v1.responses.VotingSessionResponse
import com.test.sicredi.votingservice.infraestructure.db.resources.CreateAgenda
import com.test.sicredi.votingservice.infraestructure.db.resources.CreateVotingSession
import com.test.sicredi.votingservice.main.converters.toAgendaResponse
import com.test.sicredi.votingservice.main.converters.toDbCreateAgendaInput
import com.test.sicredi.votingservice.main.converters.toDbCreateVotingSessionInput
import com.test.sicredi.votingservice.main.converters.toVotingSessionResponse
import org.springframework.stereotype.Component

@Component
class ApiV1PortAdapter(
    private val createAgenda: CreateAgenda,
    private val createVotingSession: CreateVotingSession
) : ApiV1Port {
    override fun createAgenda(request: CreateAgendaRequest): AgendaResponse =
        createAgenda.execute(request.toDbCreateAgendaInput())
            .toAgendaResponse()

    override fun createVotingSession(request: CreateVotingSessionRequest): VotingSessionResponse =
        createVotingSession.execute(request.toDbCreateVotingSessionInput())
            .toVotingSessionResponse()

    override fun registerVote(request: VoteRequest) {
        TODO("Not yet implemented")
    }
}