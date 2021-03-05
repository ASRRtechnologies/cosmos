package nl.asrr.cosmos.service

import nl.asrr.cosmos.dto.ActivityCreationDto
import nl.asrr.cosmos.exception.NotFoundException
import nl.asrr.cosmos.model.Activity
import nl.asrr.cosmos.model.Field
import nl.asrr.cosmos.model.Project
import nl.asrr.cosmos.util.Log
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Log
@Service
class ActivityService(private val projectService: ProjectService) {

    fun create(projectId: String, activityCreationDto: ActivityCreationDto): ResponseEntity<Activity>{
        val project = projectService.get(projectId)
        val exists = project.fields!!.stream().anyMatch { it.name == activityCreationDto.fieldName }

        if (!exists) throw NotFoundException("Field name ${activityCreationDto.fieldName} does not exist in project ${project.name}")

        var field = project.fields.first { it.name == activityCreationDto.fieldName }



        return ResponseEntity(null, HttpStatus.CREATED)
    }


    fun getFields(project: Project, fieldName: String): List<Field>? {
//        if (project.fields!!.stream().noneMatch { fieldName == it.name }) {
//           return project.fields + Field(fieldName, null)
//        }

        return project.fields
    }

}