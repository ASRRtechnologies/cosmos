package nl.asrr.cosmos.service

import nl.asrr.cosmos.dto.ProjectCreationDto
import nl.asrr.cosmos.model.Project
import nl.asrr.cosmos.repository.ProjectRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ProjectService(
    private val projectRepository: ProjectRepository
) {

    fun create(): Int {
        var a = 3
        return a
    }

    fun createProject(projectCreationDto: ProjectCreationDto): ResponseEntity<Project> {
        val (name, client, budget) = projectCreationDto
        val project = Project("1", name, client, "$client$name", budget)
        return ResponseEntity(projectRepository.save(project), HttpStatus.CREATED)
    }

}