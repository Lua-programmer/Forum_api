package io.github.luaprogrammer.forum_api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class UserModel(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val email: String,

    val password: String,

    @JsonIgnore //Ignora quando fizer um get no usuário
    @ManyToMany(fetch = FetchType.EAGER) //EAGER -> quando carregar o usuário, carrega todas as roles
    @JoinColumn(name = "user_role")
    val role: List<Role> = mutableListOf(),
)
