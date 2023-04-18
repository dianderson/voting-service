package com.test.sicredi.votingservice.domains.voting.rules

import com.test.sicredi.votingservice.domains.voting.fixtures.ProcessVoteInputFixture
import com.test.sicredi.votingservice.domains.voting.fixtures.VotingSessionModelFixture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import javax.management.BadAttributeValueExpException

@ExtendWith(MockitoExtension::class)
class ValidateIfTheFieldIsRightTest {

    @InjectMocks
    lateinit var validateIfTheFieldIsRight: ValidateIfTheFieldIsRight

    @Test
    fun `should not throw exception`() {
        val input = ProcessVoteInputFixture.newProcessVoteInput()
        val model = VotingSessionModelFixture.newVotingSessionModel()

        assertDoesNotThrow { validateIfTheFieldIsRight.execute(input, model) }
    }

    @Test
    fun `should throw BadAttributeValueExpException`() {
        val input = ProcessVoteInputFixture.newProcessVoteInput(votedField = "yes")
        val model = VotingSessionModelFixture.newVotingSessionModel()

        assertThrows<BadAttributeValueExpException> { validateIfTheFieldIsRight.execute(input, model) }
    }
}