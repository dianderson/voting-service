package com.test.sicredi.votingservice.infraestructure.db.resources

import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateAgendaInput
import com.test.sicredi.votingservice.infraestructure.db.models.DbAgendaModel

interface CreateAgenda {
    fun execute(input: DbCreateAgendaInput): DbAgendaModel
}