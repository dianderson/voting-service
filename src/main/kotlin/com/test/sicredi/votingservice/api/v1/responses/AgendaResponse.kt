package com.test.sicredi.votingservice.api.v1.responses

import com.test.sicredi.votingservice.common.HasResponse
import com.test.sicredi.votingservice.common.ResponseError

data class AgendaResponse(
    val response: Response? = null,
    val error: ResponseError? = null
) : HasResponse

data class Response(
    val code: String,
    val name: String,
    val subject: String
)