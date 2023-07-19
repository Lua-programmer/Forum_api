package io.github.luaprogrammer.forum_api.service

import io.github.luaprogrammer.forum_api.exception.NotFoundException
import io.github.luaprogrammer.forum_api.model.Course
import io.github.luaprogrammer.forum_api.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val repository: CourseRepository
) {

    fun getCourse(id: Long): Course {
        return repository.findById(id)
            .orElseThrow { NotFoundException("Course with id $id not found") }
    }

}
