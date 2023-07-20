package io.github.luaprogrammer.forum_api.repository

import io.github.luaprogrammer.forum_api.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserModel, Long> {
    fun findByEmail(username: String?): UserModel?
}
