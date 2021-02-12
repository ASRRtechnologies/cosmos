package nl.asrr.cosmos.activity

import nl.asrr.cosmos.service.ProjectService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AcitviyTest @Autowired constructor(private val projectService: ProjectService){

    @Test
    fun `Test code coverage`() {
        val result = projectService.create()
        assertEquals(3, result)
    }

}