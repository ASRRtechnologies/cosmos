package nl.asrr.cosmos.repository

import nl.asrr.cosmos.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun findOneById(id: String): User
    override fun deleteAll()
}