package io.github.luaprogrammer.forum_api.controller.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicUpdateRequest(

    @field:NotNull
    val id: Long,

    @field: NotEmpty(message = "Title cannot be empty")
    @field: Size(min = 2, max = 100, message = "Title must be between 5 and 100 characters")
    val title: String,

    @field: NotEmpty(message = "Message cannot be empty")
    val message: String,
)
