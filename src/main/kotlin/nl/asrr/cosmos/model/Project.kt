package nl.asrr.cosmos.model

import org.springframework.data.annotation.Id

data class Project(
    @Id
    val id: String,
    val name: String,
    val client: String,
    val code: String,
    val budget: Int?
)
