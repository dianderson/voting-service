package com.test.sicredi.votingservice.domains.voting_session

import com.test.sicredi.votingservice.domains.voting_session.fixtures.CreateVotingSessionInputFixture
import com.test.sicredi.votingservice.domains.voting_session.fixtures.VotingSessionModelFixture
import com.test.sicredi.votingservice.domains.voting_session.ports.VotingSessionPort
import com.test.sicredi.votingservice.domains.voting_session.use_cases.CreateVotingSessionImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CreateVotingSessionTest {
    @Mock
    lateinit var votingSessionPort: VotingSessionPort

    @InjectMocks
    lateinit var createVotingSession: CreateVotingSessionImpl

    @Test
    fun `should`() {
        val createVotingSessionInput = CreateVotingSessionInputFixture.newCreateVotingSessionInput()
        val votingSessionModel = VotingSessionModelFixture.newVotingSessionModel()

        `when`(votingSessionPort.createVotingSession(createVotingSessionInput)).thenReturn(votingSessionModel)
        assertDoesNotThrow {
            createVotingSession.execute(createVotingSessionInput)
        }
    }
}