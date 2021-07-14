package nl.asrr.cosmos.project.dto

data class ProjectCreationDto(
    val name: String,
    val client: String,
    val budget: Int? = null
)
