package nl.asrr.cosmos.project.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.parameters.RequestBody
import nl.asrr.cosmos.project.dto.ActivityCreationDto
import nl.asrr.cosmos.project.model.Activity
import nl.asrr.cosmos.project.service.ActivityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/projects")
class ActivityController(
    private val activityService: ActivityService
) {

    @PostMapping("/{project}")
    @Operation(summary = "Add activity to project")
    fun createActivity(@RequestBody activityCreationDto: ActivityCreationDto, @PathVariable project: String):
        ResponseEntity<Activity> {
            return activityService.create(project, activityCreationDto)
        }
}
