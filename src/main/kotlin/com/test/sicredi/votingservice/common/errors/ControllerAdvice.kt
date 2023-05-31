package com.test.sicredi.votingservice.common.errors

import jakarta.persistence.EntityNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.Instant

@ControllerAdvice
class ControllerAdvice : ResponseEntityExceptionHandler() {
    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(
        ex: EntityNotFoundException, request: HttpServletRequest
    ): ResponseEntity<ErrorHandlerModel> =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                ErrorHandlerModel(
                    timestamp = Instant.now(),
                    httpStatus = HttpStatus.NOT_FOUND.value(),
                    errors = setOf(ErrorMessageData(field = "Not found", error = ex.message ?: "Entity not found")),
                    path = request.servletPath
                )
            )

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val errors = ex.fieldErrors
            .map {
                ErrorMessageData(
                    field = it.field,
                    error = it.defaultMessage ?: "Argument not valid"
                )
            }.toSet()

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorHandlerModel(
                    timestamp = Instant.now(),
                    httpStatus = HttpStatus.BAD_REQUEST.value(),
                    errors = errors,
                    path = (request as ServletWebRequest).request.servletPath
                )
            )
    }
}