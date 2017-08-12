
package es.jaranda.poc.springbootkolindemo.model.dto.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.*

//import java.util.*

@JsonInclude(Include.NON_NULL)
class DemoGreetingResponse(
        //    var greet : Optional<String> = Optional.empty()
        var greet : String?,
        var name : String?
)
