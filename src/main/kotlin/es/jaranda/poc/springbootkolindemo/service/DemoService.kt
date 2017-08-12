
package es.jaranda.poc.springbootkolindemo.service

import es.jaranda.poc.springbootkolindemo.model.dto.response.DemoGreetingResponse
import org.springframework.stereotype.Service

interface DemoService {
    fun greet() : DemoGreetingResponse
    fun greet(greet : String, name : String?) : DemoGreetingResponse
}

@Service
class DemoServiceImpl : DemoService {
    override fun greet() = DemoGreetingResponse(greet = "Hello World!",
                                                 name = null)
    override fun greet(greet: String, name: String?) =
            DemoGreetingResponse(greet = greet, name = name)
}
