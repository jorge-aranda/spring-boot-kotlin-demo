
package es.jaranda.poc.springbootkolindemo.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(override val message: String? = null) :
      NoSuchElementException(message)
