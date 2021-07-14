package nl.asrr.cosmos.project.service

import io.mockk.every
import io.mockk.mockk
import nl.asrr.common.exceptions.DuplicationException
import nl.asrr.cosmos.app.exception.NotFoundException
import nl.asrr.cosmos.app.exception.ProjectNotFoundException
import nl.asrr.cosmos.project.dto.FieldCreationDto
import nl.asrr.cosmos.project.model.Project
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class FieldServiceTest {

    private val projectId = "ABC123"
    private val creationDto: FieldCreationDto = FieldCreationDto("Field123", projectId)

    @Test
    fun `add should throw exception if project doesn't exist`() {
        val projectService: ProjectService = mockk()
        every { projectService.get(any()) }.throws(ProjectNotFoundException("Not found"))
        val service = createService(projectService)

        assertThrows<NotFoundException> { service.add(creationDto) }
    }

    @Test
    fun `add should throw exception if field already exists`() {
        val projectService: ProjectService = mockk()
        every { projectService.get(any()) } returns getProject()
        val service = createService(projectService)

        assertThrows<DuplicationException> { service.add(creationDto) }
    }

    private fun createService(projectService: IProjectService = mockk()): FieldService {
        return FieldService(projectService)
    }

    private fun getProject(): Project {
        return Project(
            "123",
            "projectName",
            "clientName",
            100
        )
    }
}