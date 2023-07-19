package io.github.luaprogrammer.forum_api.mapper

import io.github.luaprogrammer.forum_api.controller.response.TopicResponse
import io.github.luaprogrammer.forum_api.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicResponseMapper: Mapper<Topic, TopicResponse> {
    override fun map(t: Topic): TopicResponse {
        return TopicResponse(
            id = t.id,
            title = t.title,
            message = t.message,
            createdAt = t.createdAt,
            status = t.status
        )
    }
}