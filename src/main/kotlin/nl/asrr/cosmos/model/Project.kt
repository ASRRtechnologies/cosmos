package nl.asrr.cosmos.model

import org.springframework.data.annotation.Id

data class Project(
    @Id
    val id: String,
    val name: String,
    val client: String,
    val budget: Int?,
    val github: String?,
    var fields: List<Field>?
)
