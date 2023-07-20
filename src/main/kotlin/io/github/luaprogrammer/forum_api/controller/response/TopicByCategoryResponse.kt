package io.github.luaprogrammer.forum_api.controller.response

data class TopicByCategoryResponse(
    val category: String,
    val total: Long
)
