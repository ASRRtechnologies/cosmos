package nl.asrr.cosmos.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Employee(
    @Id
    val id: ObjectId = ObjectId.get(),
    val name: String,
    val entries: MutableList<Entry>
)
