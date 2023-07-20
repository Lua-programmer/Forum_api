package io.github.luaprogrammer.forum_api.service

import io.github.luaprogrammer.forum_api.model.UserModel
import org.springframework.security.core.userdetails.UserDetails

class UserDetailService(
    private val user: UserModel,
) : UserDetails {
    override fun getAuthorities() = user.role

    override fun getPassword() = user.password

    override fun getUsername() = user.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}