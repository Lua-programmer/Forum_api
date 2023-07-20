package io.github.luaprogrammer.forum_api.repository

import io.github.luaprogrammer.forum_api.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository: JpaRepository<Topic, Long> {
    fun findByCourseName(nameCourse: String, pageable: Pageable): Page<Topic>
}
