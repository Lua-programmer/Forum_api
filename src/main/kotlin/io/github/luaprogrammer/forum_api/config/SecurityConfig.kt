package io.github.luaprogrammer.forum_api.config

import io.github.luaprogrammer.forum_api.security.JwtLoginFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val userDetailsService: UserDetailsService,
    private val configuration: AuthenticationConfiguration,
    private val jwtUtil: JwtUtil
) {

    @Bean
    fun configure(http: HttpSecurity?): SecurityFilterChain? {
        http
            ?.authorizeHttpRequests { authorize ->
                authorize
                   // .requestMatchers("/topics")
                   // .hasAuthority("LEITURA_ESCRITA")
                    .requestMatchers("/login")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
        http?.addFilterBefore(JwtLoginFilter(autManager = configuration.authenticationManager, jwtUtil = jwtUtil), UsernamePasswordAuthenticationFilter().javaClass)
        //http?.addFilterBefore(JWTAuthenticationFilterd(jwtUtil = jwtUtil), OncePerRequestFilter::class.java)
        http?.sessionManagement { it -> it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
        http?.formLogin { it -> it.disable().httpBasic {  } }
        return http?.build()
    }

    fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder())
    }

    @Bean
    fun bCryptPasswordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}