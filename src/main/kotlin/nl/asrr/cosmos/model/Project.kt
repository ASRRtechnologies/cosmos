package nl.asrr.cosmos.model

import org.springframework.data.annotation.Id
import java.time.Duration

data class Project(
    @Id
    val id: String,
    val name: String,
    val client: String,
    val budget: Int?,
    val github: String?,
    val fields: List<Field>?
)

data class Field(
    val name: String,
    val entries: List<Activity>?
)

data class Activity(
    val description: String,
    val duration: Duration
)
