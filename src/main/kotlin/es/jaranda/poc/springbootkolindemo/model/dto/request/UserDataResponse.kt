
package es.jaranda.poc.springbootkolindemo.model.dto.request

import es.jaranda.poc.springbootkolindemo.model.enums.UserRole

data class UserDataResponse(
        val id : String,
        val username: String,
        val role: UserRole,
        val active : Boolean
)
