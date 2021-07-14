package nl.asrr.cosmos.project.service

import io.mockk.every
import io.mockk.mockk
import nl.asrr.cosmos.app.exception.ProjectAlreadyExistsException
import nl.asrr.cosmos.app.repository.ProjectRepository
import nl.asrr.cosmos.project.dto.ProjectCreationDto
import nl.asrr.cosmos.project.model.Project
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ProjectServiceTest {

    private val projectName = "project123"
    private val clientName = "ASRR"

    @Test
    fun `create should throw exception if project already exists for generated id`() {
        val repository: ProjectRepository = mockk()
        every { repository.existsById(any()) } returns true
        val service = createService(repository)

        assertThrows<ProjectAlreadyExistsException> {
            service.create(getCreationDto())
        }
    }

    private fun createService(repository: ProjectRepository = mockk()): ProjectService {
        return ProjectService(repository)
    }

    private fun getCreationDto(name: String = projectName, client: String = clientName): ProjectCreationDto {
        return ProjectCreationDto(name, client)
    }

    private fun getProject(): Project {
        return Project(
            "123",
            "123",
            "123",
            1
        )
    }
}