package com.test.sicredi.votingservice.domains.agenda.ports

import com.test.sicredi.votingservice.domains.agenda.inputs.CreateAgendaInput
import com.test.sicredi.votingservice.domains.agenda.models.AgendaModel

interface AgendaPort {
    fun createAgenda(input: CreateAgendaInput): AgendaModel
}