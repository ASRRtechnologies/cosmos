package nl.asrr.cosmos.app.repository

import nl.asrr.cosmos.app.model.Project
import org.springframework.data.mongodb.repository.MongoRepository

interface ProjectRepository : MongoRepository<Project, String> {
    fun findOneById(id: String): Project
    fun findOneByName(name: String)
    override fun deleteAll()
}
