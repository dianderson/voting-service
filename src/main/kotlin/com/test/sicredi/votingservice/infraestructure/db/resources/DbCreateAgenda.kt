package com.test.sicredi.votingservice.infraestructure.db.resources

import com.test.sicredi.votingservice.infraestructure.db.inputs.DbCreateAgendaInput
import com.test.sicredi.votingservice.infraestructure.db.models.DbAgendaModel

interface DbCreateAgenda {
    fun execute(input: DbCreateAgendaInput): DbAgendaModel
}