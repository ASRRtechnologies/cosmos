package nl.asrr.cosmos.project.controller

import io.swagger.v3.oas.annotations.Operation
import nl.asrr.cosmos.project.dto.ProjectCreationDto
import nl.asrr.cosmos.project.model.Project
import nl.asrr.cosmos.project.repository.ProjectRepository
import nl.asrr.cosmos.project.service.ProjectService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
        return projectService.create(projectCreationDto)
    }

//    @PostMapping("/field")
//    @Operation(summary = "Add new field")
//    fun createField(@RequestBody fieldCreationDto: FieldCreationDto): ResponseEntity<Project> {
//        return ResponseEntity(projectService.addField(fieldCreationDto), HttpStatus.CREATED)
//    }
}
