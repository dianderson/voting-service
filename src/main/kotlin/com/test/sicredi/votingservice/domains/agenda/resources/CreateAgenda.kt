package com.test.sicredi.votingservice.domains.agenda.resources

import com.test.sicredi.votingservice.domains.agenda.inputs.CreateAgendaInput
import com.test.sicredi.votingservice.domains.agenda.models.AgendaModelResponse

interface CreateAgenda {
    fun execute(input: CreateAgendaInput): AgendaModelResponse
}