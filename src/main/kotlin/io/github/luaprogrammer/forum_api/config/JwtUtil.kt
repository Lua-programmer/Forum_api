package io.github.luaprogrammer.forum_api.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtil {

    private val expiration: Long = 60000

    @Value("\${jwt.secret}")
    private lateinit var secretKey: String

    fun generateToken(
        username: String
    ): String? {
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.HS512, secretKey.toByteArray())
            .compact()
    }
}