package nl.asrr.cosmos.controller

import io.swagger.v3.oas.annotations.Operation
import nl.asrr.cosmos.dto.ProjectCreationDto
import nl.asrr.cosmos.model.Project
import nl.asrr.cosmos.repository.ProjectRepository
import nl.asrr.cosmos.service.ProjectService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/projects")
class ProjectController(
    private val projectRepository: ProjectRepository,
    private val projectService: ProjectService
) {

    @GetMapping
    @Operation(summary = "Retrieve all projects", description = "This call retrieves all projects without a filter.")
    fun getAllProjects(): ResponseEntity<List<Project>> {
        val projects = projectRepository.findAll()
        return ResponseEntity.ok(projects)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve projects by id", description = "This call retrieves a project by id.")
    fun getOneProject(@PathVariable("id") id: String): ResponseEntity<Project> {
        val project = projectRepository.findOneById(id)
        return ResponseEntity.ok(project)
    }

    @PostMapping
    @Operation(summary = "Create new project")
    fun createProject(@RequestBody projectCreationDto: ProjectCreationDto): ResponseEntity<Project> {
        return projectService.createProject(projectCreationDto)
    }
}