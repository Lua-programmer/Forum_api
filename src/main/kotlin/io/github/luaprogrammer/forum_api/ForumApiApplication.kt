package io.github.luaprogrammer.forum_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ForumApiApplication

fun main(args: Array<String>) {
    runApplication<ForumApiApplication>(*args)
}
