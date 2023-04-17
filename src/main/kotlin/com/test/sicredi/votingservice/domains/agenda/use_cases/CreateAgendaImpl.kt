package com.test.sicredi.votingservice.domains.agenda.use_cases

import com.test.sicredi.votingservice.common.ResponseError
import com.test.sicredi.votingservice.domains.agenda.inputs.CreateAgendaInput
import com.test.sicredi.votingservice.domains.agenda.models.AgendaModelResponse
import com.test.sicredi.votingservice.domains.agenda.ports.AgendaPort
import com.test.sicredi.votingservice.domains.agenda.resources.CreateAgenda
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CreateAgendaImpl(
    private val agendaPort: AgendaPort
) : CreateAgenda {
    override fun execute(input: CreateAgendaInput): AgendaModelResponse =
        try {
            AgendaModelResponse(agendaModel = agendaPort.createAgenda(input))
        } catch (ex: Exception) {
            AgendaModelResponse(
                responseError = ResponseError(
                    timestamp = LocalDateTime.now(),
                    status = HttpStatus.BAD_REQUEST,
                    message = ex.message ?: ex.cause?.message ?: "Erro generico"
                )
            )
        }
}