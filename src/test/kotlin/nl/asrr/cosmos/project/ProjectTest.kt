package nl.asrr.cosmos.project

import nl.asrr.cosmos.service.ProjectService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProjectTest @Autowired constructor(private val projectService: ProjectService) {

    @Test
    fun `Test code coverage`() {
        val result = projectService.create()
        assertEquals(3, result)
    }
}
