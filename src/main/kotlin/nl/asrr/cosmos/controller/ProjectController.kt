package nl.asrr.cosmos.controller

import nl.asrr.cosmos.dto.ProjectCreationDto
import nl.asrr.cosmos.model.Project
import nl.asrr.cosmos.repository.ProjectRepository
import nl.asrr.cosmos.service.ProjectService
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/projects")
class ProjectController(
    private val projectRepository: ProjectRepository,
    private val projectService: ProjectService
) {

    @GetMapping
    fun getAllProjects(): ResponseEntity<List<Project>> {
        val projects = projectRepository.findAll()
        return ResponseEntity.ok(projects)
    }

    @GetMapping("/{id}")
    fun getOneProject(@PathVariable("id") id: String): ResponseEntity<Project> {
        val project = projectRepository.findOneById(id)
        return ResponseEntity.ok(project)
    }

    @PostMapping
    fun createProject(@RequestBody projectCreationDto: ProjectCreationDto): ResponseEntity<Project> {
        return projectService.createProject(projectCreationDto);
    }
}