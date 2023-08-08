package io.github.luaprogrammer.forum_api.security

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.luaprogrammer.forum_api.config.JwtUtil
import io.github.luaprogrammer.forum_api.model.Credentials
import io.github.luaprogrammer.forum_api.service.UserDetailService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class JwtLoginFilter(
    private  val autManager: AuthenticationManager?,
    private val jwtUtil: JwtUtil
): UsernamePasswordAuthenticationFilter() {
    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication? {
        val(username, password) = ObjectMapper().readValue(request?.inputStream, Credentials::class.java)
        val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(username, password)
        return autManager?.authenticate(usernamePasswordAuthenticationToken)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        val username = (authResult?.principal as UserDetailService).username
        val generateToken = jwtUtil.generateToken(username)
        response?.addHeader("Authorization", "Bearer $generateToken")
    }
}
