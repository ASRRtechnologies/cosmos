package nl.asrr.cosmos.repository

import nl.asrr.cosmos.model.Project
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ProjectRepository : MongoRepository<Project, String> {
    fun findOneById(id: ObjectId): Project
    fun findEmployeeBy(name: String): Project
    fun existsByName(name: String): Boolean
    override fun deleteAll()
}