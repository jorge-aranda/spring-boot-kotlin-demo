
package es.jaranda.poc.springbootkolindemo.controller

import es.jaranda.poc.springbootkolindemo.service.DemoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(val demoService : DemoService) {

    @GetMapping("/greet")
    fun greet() = demoService.loggedGreet()

    @GetMapping("/custom-greet")
    fun greet(@RequestParam greet : String,
              @RequestParam(required=false) name : String?
    ) = demoService.loggedGreet(greet, name)

}
