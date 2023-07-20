package io.github.luaprogrammer.forum_api.repository

import io.github.luaprogrammer.forum_api.controller.response.TopicByCategoryResponse
import io.github.luaprogrammer.forum_api.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository: JpaRepository<Topic, Long> {
    fun findByCourseName(nameCourse: String, pageable: Pageable): Page<Topic>

    @Query("SELECT new io.github.luaprogrammer.forum_api.controller.response.TopicByCategoryResponse(course.category, count(t)) " +
            "FROM Topic t JOIN t.course course GROUP BY course.category") // JPQL @QueryNative é para query natva do banco
    fun findTopicsByCategoryCourse(): List<TopicByCategoryResponse>
}
