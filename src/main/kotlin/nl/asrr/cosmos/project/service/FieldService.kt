package nl.asrr.cosmos.project.service

import nl.asrr.cosmos.project.dto.FieldCreationDto
import org.springframework.stereotype.Service

@Service
class FieldService(val projectService: IProjectService) {

    fun add(creation: FieldCreationDto) {
        val project = projectService.get(creation.projectId)


    }

}