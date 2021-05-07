package nl.asrr.cosmos.app.service

import nl.asrr.cosmos.app.dto.FieldCreationDto
import nl.asrr.cosmos.app.dto.ProjectCreationDto
import nl.asrr.cosmos.app.exception.ProjectAlreadyExistsException
import nl.asrr.cosmos.app.exception.ProjectNotFoundException
import nl.asrr.cosmos.app.model.Field
import nl.asrr.cosmos.app.model.Project
import nl.asrr.cosmos.app.repository.ProjectRepository
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
        val id = generateProjectId(projectCreationDto)

        if (exists(id)) throw ProjectAlreadyExistsException("Project with code '$id' already exists in database")

        val project = Project(id, name, client, budget, null, null)
        return ResponseEntity(projectRepository.save(project), HttpStatus.CREATED)
    }

    fun exists(id: String): Boolean {
        return projectRepository.existsById(id)
    }

    fun get(id: String): Project {
        if (!exists(id)) throw ProjectNotFoundException("Project with id '$id' not found")
        return projectRepository.findOneById(id)
    }

    fun addField(fieldCreationDto: FieldCreationDto): Project {
        val (fieldName, projectId) = fieldCreationDto
        val project = get(projectId)

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

    fun generateProjectId(projectCreationDto: ProjectCreationDto): String {
        val (name, client) = projectCreationDto
        return "$client$name".replace(" ", "")
    }
}
