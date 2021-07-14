package nl.asrr.cosmos.user.model

import org.springframework.data.annotation.Id

data class User(
    @Id
    var id: String,
    var userName: String,
    var name: String,
    var email: String?,
)
