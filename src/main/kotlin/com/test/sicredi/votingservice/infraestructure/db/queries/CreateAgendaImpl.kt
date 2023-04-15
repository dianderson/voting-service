package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateAgendaInput
import com.test.sicredi.votingservice.infraestructure.db.models.DbAgendaModel
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.AgendaRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.CreateAgenda
import org.springframework.stereotype.Component

@Component
class CreateAgendaImpl(
    private val agendaRepository: AgendaRepository
) : CreateAgenda {
    override fun execute(input: DbCreateAgendaInput): DbAgendaModel =
        agendaRepository.save(input.toEntity()).toModel()
}