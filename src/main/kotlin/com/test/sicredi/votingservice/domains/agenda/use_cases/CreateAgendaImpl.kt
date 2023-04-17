package com.test.sicredi.votingservice.domains.agenda.use_cases

import com.test.sicredi.votingservice.domains.agenda.inputs.CreateAgendaInput
import com.test.sicredi.votingservice.domains.agenda.models.AgendaModel
import com.test.sicredi.votingservice.domains.agenda.ports.AgendaPort
import com.test.sicredi.votingservice.domains.agenda.resources.CreateAgenda
import org.springframework.stereotype.Service

@Service
class CreateAgendaImpl(
    private val agendaPort: AgendaPort
) : CreateAgenda {
    override fun execute(input: CreateAgendaInput): AgendaModel =
        agendaPort.createAgenda(input)
}