package nl.asrr.cosmos.controller

import io.swagger.v3.oas.annotations.Operation
import nl.asrr.cosmos.dto.ActivityCreationDto
import nl.asrr.cosmos.dto.ProjectCreationDto
import nl.asrr.cosmos.model.Activity
import nl.asrr.cosmos.model.Project
import nl.asrr.cosmos.repository.ProjectRepository
import nl.asrr.cosmos.service.ActivityService
import nl.asrr.cosmos.service.ProjectService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/projects")
class ActivityController(
    private val activityService: ActivityService
) {

//    @GetMapping("/{project}")
//    @Operation(summary = "Retrieve activities for project")
//    fun getActivitiesForProject(@PathVariable("id") id: String): ResponseEntity<Project> {
//        val project = projectRepository.findOneById(id)
//        return ResponseEntity.ok(project)
//    }

    @PostMapping("/{project}")
    @Operation(summary = "Add activity to project")
    fun createActivity(@RequestBody activityCreationDto: ActivityCreationDto, @PathVariable field: String, @PathVariable project: String):
            ResponseEntity<Activity> {
        return activityService.create(project, activityCreationDto)
    }
}