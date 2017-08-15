
package es.jaranda.poc.springbootkolindemo.service

import es.jaranda.poc.springbootkolindemo.generateLogger
import es.jaranda.poc.springbootkolindemo.model.dto.response.DemoGreetingResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

interface DemoService {
    fun greet() : DemoGreetingResponse
    fun greet(greet : String, name : String?) : DemoGreetingResponse
    fun loggedGreet() : DemoGreetingResponse
    fun loggedGreet(greet : String, name : String?) : DemoGreetingResponse
}

@Service
class DemoServiceImpl(
        @Value("\${es.jaranda.poc.springbootkolindemo.default-greet}")
        val defaultGreet : String) : DemoService {

    val log by generateLogger()

    override fun greet() = DemoGreetingResponse(greet = defaultGreet,
                                                 name = null)
    override fun greet(greet: String, name: String?) =
            DemoGreetingResponse(greet = greet, name = name)

    override fun loggedGreet() = loggedGreet(defaultGreet, null)

    override fun loggedGreet(greet: String, name: String?)
            : DemoGreetingResponse {
        val result = greet(greet, name)
        log.info("Greet sent: '$result'")
        return result
    }

}
