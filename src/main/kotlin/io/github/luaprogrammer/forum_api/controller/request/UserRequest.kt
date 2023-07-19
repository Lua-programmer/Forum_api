package io.github.luaprogrammer.forum_api.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class UserRequest(

    @field: NotEmpty(message = "name cannot be empty")
    val name: String,

    @field: NotEmpty(message = "E-mail cannot be empty")
    @field: Email(message = "E-mail must be valid")
    val email: String,
)