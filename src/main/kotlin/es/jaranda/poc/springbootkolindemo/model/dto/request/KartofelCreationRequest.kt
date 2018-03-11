
package es.jaranda.poc.springbootkolindemo.model.dto.request

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.*

@JsonInclude(Include.NON_NULL)
data class KartofelCreationRequest (
        val id : String,
        val message : String?
)
