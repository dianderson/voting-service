package com.test.sicredi.votingservice.main.adapters

import com.test.sicredi.votingservice.domains.agenda.inputs.CreateAgendaInput
import com.test.sicredi.votingservice.domains.agenda.models.AgendaModel
import com.test.sicredi.votingservice.domains.agenda.ports.AgendaPort
import com.test.sicredi.votingservice.infraestructure.db.resources.DbCreateAgenda
import com.test.sicredi.votingservice.main.converters.toAgendaModel
import com.test.sicredi.votingservice.main.converters.toDbCreateAgendaInput
import org.springframework.stereotype.Component

@Component
class AgendaPortAdapter(
    private val createAgenda: DbCreateAgenda
) : AgendaPort {
    override fun createAgenda(input: CreateAgendaInput): AgendaModel =
        createAgenda.execute(input.toDbCreateAgendaInput()).toAgendaModel()
}