
@file:JvmName("UserMappingFunctions")

package es.jaranda.poc.springbootkolindemo.mapper

import es.jaranda.poc.springbootkolindemo.model.domain.User
import es.jaranda.poc.springbootkolindemo.model.dto.request.UserDataResponse
import es.jaranda.poc.springbootkolindemo.model.dto.request.UserRegistrationRequest
import es.jaranda.poc.springbootkolindemo.util.HasherUtil
import org.springframework.stereotype.Component

interface UserMapper {
    fun toDomain(request : UserRegistrationRequest) : User
    fun toResponse(domain : User) : UserDataResponse
}

// TODO pending to include unit test
@Component
class UserMapperImpl(val hasherUtil: HasherUtil) : UserMapper {
    override fun toDomain(request: UserRegistrationRequest) = User(
            id = request.id,
            username = request.username,
            hashedPassword = hasherUtil.hashSecret(request.password)
    )
    override fun toResponse(domain: User) = domain.toResponse()
}

fun User.toResponse() = UserDataResponse(
        id=this.id,
        username = this.username,
        role = this.role,
        active = this.active
)
