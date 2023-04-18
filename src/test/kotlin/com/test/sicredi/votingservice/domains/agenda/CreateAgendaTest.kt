package com.test.sicredi.votingservice.domains.agenda

import com.test.sicredi.votingservice.domains.agenda.fixtures.AgendaModelFixture
import com.test.sicredi.votingservice.domains.agenda.fixtures.CreateAgendaInputFixture
import com.test.sicredi.votingservice.domains.agenda.ports.AgendaPort
import com.test.sicredi.votingservice.domains.agenda.use_cases.CreateAgendaImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CreateAgendaTest {
    @Mock
    lateinit var agendaPort: AgendaPort

    @InjectMocks
    lateinit var createAgendaImpl: CreateAgendaImpl

    @Test
    fun `should`() {
        val createAgendaInput = CreateAgendaInputFixture.newCreateAgendaInput()
        val agendaModel = AgendaModelFixture.newAgendaModel()

        Mockito.`when`(agendaPort.createAgenda(createAgendaInput)).thenReturn(agendaModel)
        assertDoesNotThrow {
            createAgendaImpl.execute(createAgendaInput)
        }
    }
}