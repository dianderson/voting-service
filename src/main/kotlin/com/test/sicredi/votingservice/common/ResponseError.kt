package com.test.sicredi.votingservice.common

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ResponseError(
    val timestamp: LocalDateTime,
    val status: HttpStatus,
    val message: String
) : HasResponse