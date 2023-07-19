package io.github.luaprogrammer.forum_api.controller.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicRequest(
    @field: NotEmpty(message = "Title cannot be empty")
    @field: Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    val title: String,

    @field: NotEmpty(message = "Message cannot be empty")
    val message: String,

    @field: NotNull(message = "Course ID cannot be null")
    val idCourse: Long,

    @field: NotNull(message = "Author ID cannot be null")
    val idAuthor: Long
)