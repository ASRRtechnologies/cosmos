package nl.asrr.cosmos.service

import nl.asrr.cosmos.dto.ActivityCreationDto
import nl.asrr.cosmos.model.Activity
import nl.asrr.cosmos.model.Field
import nl.asrr.cosmos.model.Project
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ActivityService(private val projectService: ProjectService) {

    fun create(projectId: String, activityCreationDto: ActivityCreationDto): ResponseEntity<Activity>{
        val (fieldName, activityName, duration) = activityCreationDto
        val project = projectService.get(projectId)


        return ResponseEntity(null, HttpStatus.CREATED)
    }

    fun getFields(project: Project, fieldName: String): List<Field>? {
        if (project.fields!!.stream().noneMatch { fieldName == it.name }) {
           return project.fields + Field(fieldName, null)
        }

        return project.fields
    }

}