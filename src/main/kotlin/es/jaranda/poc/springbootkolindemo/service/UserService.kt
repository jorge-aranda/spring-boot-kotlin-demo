
package es.jaranda.poc.springbootkolindemo.service

import es.jaranda.poc.springbootkolindemo.model.domain.User
import es.jaranda.poc.springbootkolindemo.repository.UserRepository
import io.vavr.control.Try
import org.springframework.stereotype.Service

interface UserService {
    fun findByUsernameAndHashedPassword(
            username : String,
            hashedPassword: String) : Try<User>
    fun save(user : User)
}

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {
    override fun findByUsernameAndHashedPassword(
            username: String,
            hashedPassword: String): Try<User> {
        TODO("not implemented")
    }

    override fun save(user: User) {
        checkUsernameIsNewOrReplacement(user)

        userRepository.save(user)
    }

    private fun checkUsernameIsNewOrReplacement(user: User) {
        val persistedUser = userRepository.findByUsername(user.username)

        check(persistedUser == null || persistedUser.id == user.id,
                { "Username '${user.username}' must be unique" })
    }
}
