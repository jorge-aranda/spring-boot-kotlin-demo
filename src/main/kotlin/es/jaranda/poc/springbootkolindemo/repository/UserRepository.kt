
package es.jaranda.poc.springbootkolindemo.repository

import es.jaranda.poc.springbootkolindemo.model.domain.User
import es.jaranda.poc.springbootkolindemo.model.enums.UserRole
import es.jaranda.poc.springbootkolindemo.utils.hashWithSha256
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.stereotype.Repository

interface UserRepository {
    fun findAll() : List<User>
    fun get(id : String) : Option<User>
    fun save(user : User)

    fun findByUsername(username: String) : User?
}

// TODO pending to include unit test
@Repository
class UserRepositoryImpl : UserRepository {
    private val users : MutableMap<String, User> = mutableMapOf(
            "1" to User(
                    id="1",
                    username="admin",
                    hashedPassword = "admin".hashWithSha256(),
                    role = UserRole.ADMIN
            ),
            "2" to User(
                    id="2",
                    username="user",
                    hashedPassword = "user".hashWithSha256()
            )
    )

    override fun findAll() = users.values.toList()
    override fun get(id : String) = users[id].option()
    override fun save(user: User) {
        users[user.id] = user
    }

    override fun findByUsername(username: String) =
            users.values.singleOrNull { user -> username == user.username }
}
