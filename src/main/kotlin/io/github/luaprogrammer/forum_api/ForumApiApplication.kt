package io.github.luaprogrammer.forum_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForumApiApplication

fun main(args: Array<String>) {
    runApplication<ForumApiApplication>(*args)
}
