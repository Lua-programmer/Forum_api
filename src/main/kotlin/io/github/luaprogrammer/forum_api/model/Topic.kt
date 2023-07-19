package io.github.luaprogrammer.forum_api.model

import io.github.luaprogrammer.forum_api.enum.TopicStatus
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topic(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var title: String,

    var message: String,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: Course,

    @ManyToOne
    val author: UserModel,

    @Enumerated(EnumType.STRING)
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,

    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList()
)
