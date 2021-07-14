package nl.asrr.cosmos.project.model

import org.springframework.data.annotation.Id

data class Project(
    @Id
    val id: String,
    val name: String,
    val client: String,
    val budget: Int = 0,
    val github: String? = "",
    var fields: MutableList<Field> = mutableListOf()
)
