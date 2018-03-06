
package es.jaranda.poc.springbootkolindemo.service

import es.jaranda.poc.springbootkolindemo.exceptions.InvalidCredentialsException
import es.jaranda.poc.springbootkolindemo.exceptions.ResourceNotFoundException
import es.jaranda.poc.springbootkolindemo.model.domain.User
import es.jaranda.poc.springbootkolindemo.repository.UserRepository
import io.vavr.control.Try
import io.vavr.kotlin.`try`
import io.vavr.kotlin.option
import org.springframework.stereotype.Service

interface UserService {
    fun findAll() : List<User>
    fun get(id : String) : Try<User>
    fun save(user : User)

    fun findByUsernameAndHashedPassword(
            username : String,
            hashedPassword: String) : Try<User>
}

// TODO pending to include unit test
@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {

    override fun findAll() = userRepository.findAll()
    override fun get(id: String): Try<User> = `try` {
        userRepository.get(id)
                .getOrElseThrow {
                    ResourceNotFoundException(
                            "User with id=$id not found"
                    )
                }
    }

    override fun save(user: User) {
        checkUsernameIsNewOrReplacement(user)

        userRepository.save(user)
    }

    override fun findByUsernameAndHashedPassword(
            username: String,
            hashedPassword: String
    ): Try<User> = userRepository.findByUsername(username)
            .takeIf { user -> user?.hashedPassword == hashedPassword }
            .option()
            .toTry { InvalidCredentialsException() }

    private fun checkUsernameIsNewOrReplacement(user: User) {
        val persistedUser = userRepository.findByUsername(user.username)

        check(persistedUser == null || persistedUser.id == user.id,
                { "Username '${user.username}' must be unique" })
    }
}
