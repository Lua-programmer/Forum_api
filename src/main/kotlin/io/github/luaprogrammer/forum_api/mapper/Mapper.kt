package io.github.luaprogrammer.forum_api.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}