
package es.jaranda.poc.springbootkolindemo.service

import es.jaranda.poc.springbootkolindemo.model.dto.response.DemoGreetingResponse
import org.springframework.stereotype.Service

interface DemoService {
    fun greet() : DemoGreetingResponse
}

@Service
class DemoServiceImpl : DemoService {
    override fun greet() = DemoGreetingResponse(greet = "Hello World!")
}
