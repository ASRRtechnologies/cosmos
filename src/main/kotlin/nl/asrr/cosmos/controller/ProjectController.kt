package nl.asrr.cosmos.controller

import nl.asrr.cosmos.model.Project
import nl.asrr.cosmos.repository.ProjectRepository
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/projects")
class ProjectController (private val projectRepository: ProjectRepository){

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
}