package io.github.luaprogrammer.forum_api.mapper

import io.github.luaprogrammer.forum_api.controller.request.TopicRequest
import io.github.luaprogrammer.forum_api.model.Topic
import io.github.luaprogrammer.forum_api.service.CourseService
import io.github.luaprogrammer.forum_api.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicRequestMapper(
    private val userService: UserService,
    private val courseService: CourseService
): Mapper<TopicRequest, Topic> {
    override fun map(t: TopicRequest): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.getCourse(t.idCourse),
            author = userService.getUser(t.idAuthor)
        )
    }

}