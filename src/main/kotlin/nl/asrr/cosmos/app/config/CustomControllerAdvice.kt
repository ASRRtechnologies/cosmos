package nl.asrr.cosmos.app.config

import nl.asrr.cosmos.app.exception.ErrorDetails
import nl.asrr.cosmos.app.exception.ProjectAlreadyExistsException
import nl.asrr.cosmos.user.exception.UserAlreadyExistsException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.Date

@ControllerAdvice
class CustomControllerAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler(
        value = [
            ProjectAlreadyExistsException::class,
            UserAlreadyExistsException::class
        ]
    )
    fun handleDuplication(ex: Exception, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            Date(),
            "Duplication Exception",
            ex.message!!
        )
        return ResponseEntity(errorDetails, HttpStatus.CONFLICT)
    }
}
