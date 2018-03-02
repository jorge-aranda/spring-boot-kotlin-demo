
package es.jaranda.poc.springbootkolindemo.configuration

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletResponse

@RestControllerAdvice
class ControllersConfiguration {

    @ExceptionHandler(
            IllegalStateException::class,
            IllegalArgumentException::class
    )
    fun handleBadRequests(ex: Exception, response: HttpServletResponse) {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.message)
    }

}
