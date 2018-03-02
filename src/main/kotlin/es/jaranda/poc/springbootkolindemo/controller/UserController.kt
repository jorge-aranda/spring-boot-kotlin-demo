
package es.jaranda.poc.springbootkolindemo.controller

import es.jaranda.poc.springbootkolindemo.mapper.UserMapper
import es.jaranda.poc.springbootkolindemo.model.dto.request.UserDataResponse
import es.jaranda.poc.springbootkolindemo.model.dto.request.UserRegistrationRequest
import es.jaranda.poc.springbootkolindemo.service.UserService
import org.springframework.web.bind.annotation.*

@RequestMapping("/users")
@RestController
class UserController(val userService: UserService,
                     val userMapper: UserMapper) {

    @GetMapping
    fun findAll() : List<UserDataResponse> {
        TODO("not implemented")
    }

    @GetMapping("{id}")
    fun get(@PathVariable("id") id : String) =
        userMapper.toResponse(
                userService.get(id).get()
        )

    @PostMapping
    fun registerUser(
            @RequestBody userRegistrationRequest: UserRegistrationRequest){
        check(userRegistrationRequest.password ==
                userRegistrationRequest.repeatedPassword,
                {"Values 'password' and 'repeatedPassword' must be equal"}
        )

        userService.save(userMapper.toDomain(userRegistrationRequest))
    }

}
