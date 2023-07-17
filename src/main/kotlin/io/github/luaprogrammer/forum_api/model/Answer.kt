package io.github.luaprogrammer.forum_api.model

import java.time.LocalDateTime

data class Answer(
    val id: Long?,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: UserModel,
    val topic: Topic,
    val solution: Boolean
)
