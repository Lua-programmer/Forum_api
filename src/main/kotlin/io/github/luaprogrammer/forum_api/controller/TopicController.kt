package io.github.luaprogrammer.forum_api.controller

import io.github.luaprogrammer.forum_api.controller.request.TopicRequest
import io.github.luaprogrammer.forum_api.controller.request.TopicUpdateRequest
import io.github.luaprogrammer.forum_api.controller.response.TopicResponse
import io.github.luaprogrammer.forum_api.service.TopicService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getTopics(@RequestParam(required = false) nameCourse: String?,
                  @PageableDefault(size = 5, sort = ["createdAt"], direction = Sort.Direction.DESC) pageable: Pageable): Page<TopicResponse> {
        return service.getTopics(nameCourse, pageable)
    }

    @GetMapping("/{id}")
    fun getTopic(@PathVariable id: Long): TopicResponse {
        return service.getTopic(id)
    }

    @PostMapping
    @Transactional
    fun createTopic(
        @RequestBody @Valid topicRequest: TopicRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicResponse> {
        val topicResponse = service.createTopic(topicRequest)
        val uri = uriBuilder.path("/api/topicos/${topicResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicResponse)
    }

    @PutMapping
    @Transactional
    fun updateTopic(@RequestBody @Valid topicUpdateRequest: TopicUpdateRequest): ResponseEntity<TopicResponse> {
        val topicResponse = service.updateTopic(topicUpdateRequest)
        return ResponseEntity.ok(topicResponse)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }

}