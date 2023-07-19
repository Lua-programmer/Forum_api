package io.github.luaprogrammer.forum_api.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Answer(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val message: String,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val author: UserModel,

    @ManyToOne
    val topic: Topic,

    val solution: Boolean
)
