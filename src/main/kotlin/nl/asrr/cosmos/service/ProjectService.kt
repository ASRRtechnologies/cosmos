package nl.asrr.cosmos.service

import nl.asrr.cosmos.dto.ProjectCreationDto
import nl.asrr.cosmos.exception.ProjectAlreadyExistsException
import nl.asrr.cosmos.exception.ProjectNotFoundException
import nl.asrr.cosmos.model.Field
import nl.asrr.cosmos.model.Project
import nl.asrr.cosmos.repository.ProjectRepository
import nl.asrr.cosmos.util.Log
import nl.asrr.cosmos.util.Log.Companion.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Log
@Service
class ProjectService(
    private val projectRepository: ProjectRepository
) {

    fun create(): Int {
        return 3
    }

    fun createProject(projectCreationDto: ProjectCreationDto): ResponseEntity<Project> {
        val (name, client, budget) = projectCreationDto
        val code = "$client$name"

        if (exists(code)) throw ProjectAlreadyExistsException("Project with code '$code' already exists in database")

        val project = Project(code, name, client, budget, null, null)
        return ResponseEntity(projectRepository.save(project), HttpStatus.CREATED)
    }

    fun exists(id: String): Boolean {
        return projectRepository.existsById(id)
    }

    fun get(id: String): Project {
        if (!exists(id)) throw ProjectNotFoundException("Project with id '$id' not found")
        return projectRepository.findOneById(id)
    }

    fun addField(id: String, fieldName: String): Project {
        val project = get(id)

        if (project.fields == null) {
            logger.info("hi")
            project.fields = listOf(Field(fieldName, null))
            return projectRepository.save(project)
        }

        if (project.fields!!.stream().noneMatch { it.name == fieldName }) {
            project.fields = project.fields!! + Field(fieldName, null)
            return projectRepository.save(project)
        }

        return project
    }

}