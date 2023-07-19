package io.github.luaprogrammer.forum_api.controller.response

import io.github.luaprogrammer.forum_api.enum.TopicStatus
import java.time.LocalDateTime

data class TopicResponse (
    val id: Long? = null,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)