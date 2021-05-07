package nl.asrr.cosmos.controller

import io.swagger.v3.oas.annotations.Operation
import nl.asrr.cosmos.dto.ActivityCreationDto
import nl.asrr.cosmos.model.Activity
import nl.asrr.cosmos.service.ActivityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
