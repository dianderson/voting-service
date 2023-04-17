package com.test.sicredi.votingservice.domains.agenda.resources

import com.test.sicredi.votingservice.domains.agenda.inputs.CreateAgendaInput
import com.test.sicredi.votingservice.domains.agenda.models.AgendaModel

interface CreateAgenda {
    fun execute(input: CreateAgendaInput): AgendaModel
}