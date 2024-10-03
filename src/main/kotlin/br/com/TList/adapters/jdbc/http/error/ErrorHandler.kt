package br.com.TList.adapters.jdbc.http.error

import br.com.TList.application.Task.exception.TaskNaoEncontradaException
import br.com.TList.domain.task.Task
import ch.qos.logback.classic.spi.ThrowableProxyVO
import mu.KotlinLogging
import org.springframework.http.HttpMessage
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

private val LOGGER = KotlinLogging.logger { }

@ControllerAdvice
class ErrorHandler() {
    @ExceptionHandler(Exception::class)
    fun handlerException(ex: Exception): ResponseEntity<ErrorResponse>{
        return ex.toServerResponse();
    }
}

private fun Throwable.toResponse(): Pair<HttpStatus, ErrorResponse> =
    when (this) {
        is TaskNaoEncontradaException -> toResponse(
            id = this.taskId,
            statusCode = Httpstatus.NOT_FOUND,
        )
        else -> {
            toResponse(
                statusCode = HttpStatus.BAD_REQUEST,
            )
        }
    }

private fun Throwable.toReponse(
    id: UUID? = null,
    statusCode: HttpStatusCode,
    message: String = this.message ?: "",
): Pair<HttpStatusCode, ErrorResponse> {
    val response = ErrorResponse(
        id = id,
        message = message,
    )
    val fullMessage = "[${statusCode.value()}] [${this.javaClass.simpleName}] $message"
    if (statusCode.is5xxServerError){
        LOGGER.error(this) { fullMessage }
    }else{
        LOGGER.warn { fullMessage }
    }
    return statusCode to response
}



fun Throwable.toServerResponse(): ResponseEntity<ErrorResponse> {
    val (statusCode, response) = toResponse()
    return ResponseEntity.status(statusCode).body(response)
}