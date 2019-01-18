package demo.kotlin.model.entities

import org.springframework.data.annotation.Id
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class User(
        username: String,
        password: String,
        var roles: MutableList<Role> = mutableListOf(Role.ROLE_USER), // Default Role : USER
        var active: Boolean = true,
        @Id val id: UUID = UUID.randomUUID()
) : UserDetails {

    private var username = username
    private var password = password

    override fun getUsername() = this.username

    override fun getPassword() = this.password

    override fun getAuthorities() = this.roles

    override fun isEnabled() = this.active

    override fun isCredentialsNonExpired() = false

    override fun isAccountNonExpired() = false

    override fun isAccountNonLocked() = false

    fun setPassword(password: String) {
        this.password = password
    }
}