package io.github.luaprogrammer.forum_api.service

import io.github.luaprogrammer.forum_api.controller.request.TopicRequest
import io.github.luaprogrammer.forum_api.controller.request.TopicUpdateRequest
import io.github.luaprogrammer.forum_api.controller.response.TopicResponse
import io.github.luaprogrammer.forum_api.exception.NotFoundException
import io.github.luaprogrammer.forum_api.mapper.TopicRequestMapper
import io.github.luaprogrammer.forum_api.mapper.TopicResponseMapper
import io.github.luaprogrammer.forum_api.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val TOPIC_NOT_FOUND = "Topic not found"

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicResponseMapper: TopicResponseMapper,
    private val topicRequestMapper: TopicRequestMapper
) {
    fun getTopics(nameCourse: String?, pageable: Pageable): Page<TopicResponse> {
        when (nameCourse) {
            null -> return repository.findAll(pageable).map { topicResponseMapper.map(it) }
            else -> return repository.findByCourseName(nameCourse, pageable).map { topicResponseMapper.map(it) }
        }
    }

    fun getTopic(id: Long): TopicResponse {
        return repository.findById(id)
            .map { topicResponseMapper.map(it) }
            .orElseThrow { throw NotFoundException(TOPIC_NOT_FOUND) }
    }

    fun createTopic(topicRequest: TopicRequest): TopicResponse {
        val topic = topicRequestMapper.map(topicRequest)
        return topicResponseMapper.map(repository.save(topic))
    }

    fun updateTopic(topicUpdateRequest: TopicUpdateRequest): TopicResponse {
        val topic = repository.findById(topicUpdateRequest.id)
            .orElseThrow { throw NotFoundException(TOPIC_NOT_FOUND) }
        topic.title = topicUpdateRequest.title
        topic.message = topicUpdateRequest.message
        return topicResponseMapper.map(repository.save(topic))
    }

    fun deleteTopic(id: Long) {
        val topic = repository.findById(id)
            .orElseThrow { throw NotFoundException(TOPIC_NOT_FOUND) }
        repository.delete(topic)
    }
}