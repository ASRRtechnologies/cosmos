package nl.asrr.cosmos.exception

import nl.asrr.cosmos.exception.ErrorDetails
import nl.asrr.cosmos.exception.ProjectAlreadyExistsException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class CustomControllerAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(ProjectAlreadyExistsException::class)])
    fun handleDuplication(ex: Exception, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            Date(),
            "Duplication Exception",
            ex.message!!
        )
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }
}