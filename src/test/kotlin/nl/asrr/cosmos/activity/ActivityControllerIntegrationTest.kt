package nl.asrr.cosmos.activity

import nl.asrr.cosmos.dto.ProjectCreationDto
import nl.asrr.cosmos.model.Project
import nl.asrr.cosmos.repository.ProjectRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ActivityControllerIntegrationTest @Autowired constructor(
    private val projectRepository: ProjectRepository,
    private val restTemplate: TestRestTemplate
) {
    private val defaultProjectId = "id1"

    @LocalServerPort
    protected var port: Int = 0

    @BeforeEach
    fun setUp() {
        projectRepository.deleteAll()
    }

    private fun getRootUrl(): String? = "http://localhost:$port/api/v1/projects"

    private fun saveOneProject() = projectRepository.save(
        getProject()
    )

    private fun getProject() = Project(
        defaultProjectId,
        "Name",
        "Client",
        "P123",
        1000,
        "ASRRtechnologies/cosmos",
        null
    )

    @Test
    fun `should return all projects`() {
        saveOneProject()

        val response = restTemplate.getForEntity(
            getRootUrl(),
            List::class.java
        )

        assertEquals(200, response.statusCode.value())
        assertNotNull(response.body)
        assertEquals(1, response.body?.size)
    }

    @Test
    fun `should return single project by id`() {
        saveOneProject()

        val response = restTemplate.getForEntity(
            getRootUrl() + "/$defaultProjectId",
            Project::class.java
        )

        assertEquals(200, response.statusCode.value())
        assertNotNull(response.body)
        assertEquals(defaultProjectId, response.body?.id)
    }

    @Test
    fun `should create one project`() {
        val project = getProject()
        val (_, name, client, _, budget) = project
        val request = ProjectCreationDto(name, client, budget)

        val create = restTemplate.exchange(
            getRootUrl(),
            HttpMethod.POST,
            HttpEntity(request, HttpHeaders()),
            Project::class.java
        )

        assertEquals(201, create.statusCode.value())

        val responseId = create.body?.id!!
        val (foundId, foundName, foundClient, foundCode, foundBudget) = projectRepository.findById(responseId).orElse(null)

        assertEquals(responseId, foundId)
        assertEquals(name, foundName)
        assertEquals(client, foundClient)
        assertEquals("$client$name", foundCode)
        assertEquals(budget, foundBudget)
    }
}
