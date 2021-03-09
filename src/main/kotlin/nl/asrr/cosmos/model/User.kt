package nl.asrr.cosmos.model

import org.springframework.data.annotation.Id

data class User(
    @Id
    var id: String,
    var name: String,
    var email: String?
)
