package io.github.luaprogrammer.forum_api.service

import io.github.luaprogrammer.forum_api.exception.NotFoundException
import io.github.luaprogrammer.forum_api.model.UserModel
import io.github.luaprogrammer.forum_api.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
) : UserDetailsService {

    fun getUser(id: Long): UserModel {
        return repository.findById(id)
            .orElseThrow { NotFoundException("User with id $id not found") }
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repository.findByEmail(username) ?: throw NotFoundException("User with email $username not found")
        return UserDetailService(user)
    }

}
