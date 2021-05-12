package nl.asrr.cosmos.user.dto

import nonapi.io.github.classgraph.json.Id

data class UserCreationDto(
    @Id
    val username: String,
    val name: String,
    val email: String
)
