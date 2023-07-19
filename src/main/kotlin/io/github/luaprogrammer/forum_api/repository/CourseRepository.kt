package io.github.luaprogrammer.forum_api.repository

import io.github.luaprogrammer.forum_api.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository: JpaRepository<Course, Long> {}
