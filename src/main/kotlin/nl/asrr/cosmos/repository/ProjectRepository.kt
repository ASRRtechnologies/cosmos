package nl.asrr.cosmos.repository

import nl.asrr.cosmos.model.Project
import org.springframework.data.mongodb.repository.MongoRepository

interface ProjectRepository : MongoRepository<Project, String> {
    fun findOneById(id: String): Project
    fun findEmployeeBy(name: String): Project
    fun existsByName(name: String): Boolean
    override fun deleteAll()
}