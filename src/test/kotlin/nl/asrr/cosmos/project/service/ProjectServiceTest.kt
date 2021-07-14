package nl.asrr.cosmos.project.service

import io.mockk.every
import io.mockk.mockk
import nl.asrr.cosmos.app.exception.ProjectAlreadyExistsException
import nl.asrr.cosmos.app.exception.ProjectNotFoundException
import nl.asrr.cosmos.project.dto.ProjectCreationDto
import nl.asrr.cosmos.project.model.Project
import nl.asrr.cosmos.project.repository.ProjectRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.springframework.http.HttpStatus

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

    @Test
    fun `create should result in created for success`() {
        val repository: ProjectRepository = mockk()
        every { repository.existsById(any()) } returns false
        every { repository.save(any()) } returns getProject()
        val service = createService(repository)

        val result = service.create(getCreationDto())

        Assertions.assertEquals(HttpStatus.CREATED, result.statusCode)
    }

    @Test
    fun `get should throw exception if project doesnt exist`() {
        val repository: ProjectRepository = mockk()
        every { repository.existsById(any()) } returns false
        val service = createService(repository)

        assertThrows<ProjectNotFoundException> {
            service.get("123")
        }
    }

    @Test
    fun `get should return project if exists`() {
        val repository: ProjectRepository = mockk()
        every { repository.existsById(any()) } returns true
        every { repository.findOneById(any()) } returns getProject()
        val service = createService(repository)

        val result = service.get("123")

        Assertions.assertEquals(result, getProject())
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
            projectName,
            clientName,
            100
        )
    }
}
