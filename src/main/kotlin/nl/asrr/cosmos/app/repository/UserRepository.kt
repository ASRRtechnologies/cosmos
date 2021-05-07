package nl.asrr.cosmos.app.repository

import nl.asrr.cosmos.app.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun findOneById(id: String): User
    override fun deleteAll()
}
