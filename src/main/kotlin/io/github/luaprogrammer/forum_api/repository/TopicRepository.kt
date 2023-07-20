package io.github.luaprogrammer.forum_api.repository

import io.github.luaprogrammer.forum_api.model.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository: JpaRepository<Topic, Long> {
    fun findByCourseName(nameCourse: String): List<Topic>
}
