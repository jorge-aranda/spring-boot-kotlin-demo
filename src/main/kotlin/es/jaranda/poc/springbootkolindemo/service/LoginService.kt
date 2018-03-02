
package es.jaranda.poc.springbootkolindemo.service

import es.jaranda.poc.springbootkolindemo.model.domain.User
import io.vavr.control.Try
import org.springframework.stereotype.Service

interface LoginService {
    fun login(username : String, password: String) : Try<User>
}

@Service
class LoginServiceImpl(val userService: UserService) : LoginService {
    override fun login(username: String, password: String): Try<User> {
        TODO("not implemented")
    }
}
