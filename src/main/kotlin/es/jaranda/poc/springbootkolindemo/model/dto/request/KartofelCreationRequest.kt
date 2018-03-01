
package es.jaranda.poc.springbootkolindemo.model.dto.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class KartofelCreationRequest @JsonCreator constructor(
        @JsonProperty("id") val id : String,
        @JsonProperty("message") val message : String?
)
