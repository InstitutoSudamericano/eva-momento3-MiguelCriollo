package com.example.evam3.controller

import com.example.evam3.dto.ValidationErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.time.LocalDateTime


@ControllerAdvice
class ValidationExceptionHandler {
    @ExceptionHandler(BindException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationException(ex: BindException): ResponseEntity<ValidationErrorResponse> {
        val errors = mutableMapOf<String, String>()

        val response = ValidationErrorResponse(
            timestamp = LocalDateTime.now().toString(),
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.reasonPhrase,
            message = "La solicitud contiene errores de validación",
            errors = ex.fieldErrors.map {
                ValidationErrorResponse.FieldError(
                    field = it.field,
                    message = it.defaultMessage ?: "Error de validación"
                )
            }
        );

        return ResponseEntity.badRequest().body(response)
    }
}
