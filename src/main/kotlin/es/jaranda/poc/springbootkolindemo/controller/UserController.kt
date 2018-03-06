
package es.jaranda.poc.springbootkolindemo.controller

import es.jaranda.poc.springbootkolindemo.mapper.UserMapper
import es.jaranda.poc.springbootkolindemo.model.dto.request.UserDataResponse
import es.jaranda.poc.springbootkolindemo.model.dto.request.UserRegistrationRequest
import es.jaranda.poc.springbootkolindemo.service.UserService
import org.springframework.web.bind.annotation.*

// TODO pending to include an integration test?
@RequestMapping("/users")
@RestController
class UserController(val userService: UserService,
                     val userMapper: UserMapper) {

    @GetMapping
    fun findAll() : List<UserDataResponse> =
            userService.findAll()
            .map(userMapper::toResponse)

    @GetMapping("{id}")
    fun get(@PathVariable("id") id : String) =
        userMapper.toResponse(
                userService.get(id).get()
        )

    @PostMapping
    fun registerUser(
            @RequestBody userRegistrationRequest: UserRegistrationRequest) {
        require(userRegistrationRequest.password ==
                userRegistrationRequest.repeatedPassword,
                {"Values 'password' and 'repeatedPassword' must be equal"}
        )

        userService.save(userMapper.toDomain(userRegistrationRequest))
    }

}
