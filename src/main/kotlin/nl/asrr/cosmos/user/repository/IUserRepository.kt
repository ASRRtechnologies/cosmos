package nl.asrr.cosmos.user.repository

import nl.asrr.cosmos.user.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface IUserRepository : MongoRepository<User, String> {
    fun findOneById(id: String): User
    override fun deleteAll()
    fun existsByUserName(userName: String): Boolean
}
