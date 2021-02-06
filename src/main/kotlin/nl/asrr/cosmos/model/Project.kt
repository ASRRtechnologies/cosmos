package nl.asrr.cosmos.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class Project(
    @Id
    val id: ObjectId = ObjectId.get(),
    val name: String,
    val client: String,
    val code: String,
    val budget: Int?
)
