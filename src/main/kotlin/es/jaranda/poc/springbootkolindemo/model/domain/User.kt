
package es.jaranda.poc.springbootkolindemo.model.domain

import es.jaranda.poc.springbootkolindemo.model.enums.UserRole

data class User(
    val id : String,
    val username: String,
    val hashedPassword: String,
    val role: UserRole = UserRole.USER,

    val active : Boolean = true
)
