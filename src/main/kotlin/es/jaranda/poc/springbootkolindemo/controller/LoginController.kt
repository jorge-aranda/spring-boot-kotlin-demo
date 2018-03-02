
package es.jaranda.poc.springbootkolindemo.controller

import es.jaranda.poc.springbootkolindemo.mapper.UserMapper
import es.jaranda.poc.springbootkolindemo.model.dto.request.LoginRequest
import es.jaranda.poc.springbootkolindemo.service.LoginService
import org.springframework.web.bind.annotation.*

@RequestMapping("/login")
@RestController
class LoginController(val loginService: LoginService,
                      val userMapper: UserMapper) {

    @PostMapping
    fun login(@RequestBody loginRequest: LoginRequest) =
            userMapper.toResponse(
                loginService
                        .login(loginRequest.username, loginRequest.password)
                        .get()
            )

    @DeleteMapping
    fun logout() {
        TODO("not implemented")
    }

}
