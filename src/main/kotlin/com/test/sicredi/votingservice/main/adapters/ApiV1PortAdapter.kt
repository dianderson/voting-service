package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.api.v1.dto.requests.CreateAgendaRequest
import com.test.sicredi.votingservice.api.v1.dto.requests.CreateVotingSessionRequest
import com.test.sicredi.votingservice.api.v1.dto.requests.VoteRegister
import com.test.sicredi.votingservice.api.v1.dto.responses.AgendaResponse
import com.test.sicredi.votingservice.api.v1.dto.responses.VotingSessionResponse
import com.test.sicredi.votingservice.api.v1.ports.ApiV1Port
import com.test.sicredi.votingservice.domains.agenda.resources.CreateAgenda
import com.test.sicredi.votingservice.domains.voting.resources.RegisterVote
import com.test.sicredi.votingservice.domains.voting_session.resources.CreateVotingSession
import com.test.sicredi.votingservice.main.converters.*
import org.springframework.stereotype.Component

@Component
class ApiV1PortAdapter(
    private val createAgenda: CreateAgenda,
    private val createVotingSession: CreateVotingSession,
    private val registerVote: RegisterVote
) : ApiV1Port {
    override fun createAgenda(request: CreateAgendaRequest): AgendaResponse =
        createAgenda.execute(request.toCreateAgendaInput())
            .toAgendaResponse()

    override fun createVotingSession(request: CreateVotingSessionRequest): VotingSessionResponse? =
        createVotingSession.execute(request.toCreateVotingSessionInput())
            ?.toVotingSessionResponse()

    override fun registerVote(request: VoteRegister) {
        registerVote.execute(request.toRegisterVoteInput())
    }
}