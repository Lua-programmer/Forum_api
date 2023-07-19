package io.github.luaprogrammer.forum_api.service

import io.github.luaprogrammer.forum_api.exception.NotFoundException
import io.github.luaprogrammer.forum_api.model.UserModel
import io.github.luaprogrammer.forum_api.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {

    fun getUser(id: Long): UserModel {
        return repository.findById(id)
            .orElseThrow { NotFoundException("User with id $id not found") }
    }

}
