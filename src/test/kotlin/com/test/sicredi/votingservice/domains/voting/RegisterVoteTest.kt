package com.test.sicredi.votingservice.domains.voting

import com.test.sicredi.votingservice.domains.voting.fixtures.RegisterVoteInputFixture
import com.test.sicredi.votingservice.domains.voting.ports.VotingPort
import com.test.sicredi.votingservice.domains.voting.use_cases.RegisterVoteImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class RegisterVoteTest {
    @Mock
    lateinit var votingPort: VotingPort

    @InjectMocks
    lateinit var registerVote: RegisterVoteImpl

    @Test
    fun `should throw`() {
        val registerVoteInput = RegisterVoteInputFixture.newRegisterVoteInput()

        `when`(votingPort.registerVote(registerVoteInput.votingSessionCode, registerVoteInput.votedField))
            .thenReturn(Unit)
        assertDoesNotThrow {
            registerVote.execute(registerVoteInput)
        }
    }
}