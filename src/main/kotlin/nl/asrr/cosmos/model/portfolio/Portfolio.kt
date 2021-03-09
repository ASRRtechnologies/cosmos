package nl.asrr.cosmos.model.portfolio

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class Portfolio(
    @Id
    var id: ObjectId = ObjectId.get(),
    var user: String,
    var categories: List<Category>?
)
