package nl.asrr.cosmos.project

import nl.asrr.cosmos.model.Project
import nl.asrr.cosmos.repository.ProjectRepository
import org.bson.types.ObjectId
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
import org.springframework.test.context.junit.jupiter.SpringExtension


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProjectControllerIntegrationTest @Autowired constructor(
    private val projectRepository: ProjectRepository,
    private val restTemplate: TestRestTemplate
) {
    private val defaultProjectId = ObjectId.get()

    @LocalServerPort
    protected var port: Int = 0

    @BeforeEach
    fun setUp() {
        projectRepository.deleteAll()
    }

    private fun getRootUrl(): String? = "http://localhost:$port/api/v1/projects"

    private fun saveOnePatient() = projectRepository.save(Project(defaultProjectId, "Name", "Client", "P123", 1000))

    @Test
    fun `should return all patients`() {
        saveOnePatient()

        val response = restTemplate.getForEntity(
            getRootUrl(),
            List::class.java
        )

        assertEquals(200, response.statusCode.value())
        assertNotNull(response.body)
        assertEquals(1, response.body?.size)
    }

//    @Test
//    fun `should return single patient by id`() {
////        saveOnePatient()
////
////        val response = restTemplate.getForEntity(
////            getRootUrl() + "/$defaultProjectId",
////            Project::class.java
////        )
////
////        assertEquals(200, response.statusCode.value())
////        assertNotNull(response.body)
////        assertEquals(defaultProjectId, response.body?.id)
//    }
}
