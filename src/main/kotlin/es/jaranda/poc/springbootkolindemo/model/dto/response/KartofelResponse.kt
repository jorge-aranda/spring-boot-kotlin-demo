
package es.jaranda.poc.springbootkolindemo.model.dto.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class KartofelResponse(
        var id : String?,
        var message : String?
)
