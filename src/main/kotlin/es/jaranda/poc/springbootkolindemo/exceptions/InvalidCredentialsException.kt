
package es.jaranda.poc.springbootkolindemo.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class InvalidCredentialsException : RuntimeException("Invalid credentials")
