
package es.jaranda.poc.springbootkolindemo.model.dto.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserRegistrationRequest @JsonCreator constructor(
        @JsonProperty("id")               val id : String,
        @JsonProperty("username")         val username: String,
        @JsonProperty("password")         val password: String,
        @JsonProperty("repeatedPassword") val repeatedPassword: String
)
