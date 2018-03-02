
package es.jaranda.poc.springbootkolindemo.controller

import es.jaranda.poc.springbootkolindemo.model.dto.request.LoginRequest
import es.jaranda.poc.springbootkolindemo.service.LoginService
import org.springframework.web.bind.annotation.*

@RequestMapping("/login")
@RestController
class LoginController(val loginService: LoginService) {

    @PostMapping
    fun login(@RequestBody loginRequest: LoginRequest) {
        loginService.login(loginRequest.username, loginRequest.password)
    }

    @DeleteMapping
    fun logout() : Unit {
        TODO("not implemented")
    }

}
