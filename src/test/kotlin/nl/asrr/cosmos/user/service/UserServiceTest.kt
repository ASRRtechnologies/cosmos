package nl.asrr.cosmos.user.service

import io.mockk.every
import io.mockk.mockk
import nl.asrr.cosmos.user.dto.UserCreationDto
import nl.asrr.cosmos.user.exception.UserAlreadyExistsException
import nl.asrr.cosmos.user.model.User
import nl.asrr.cosmos.user.repository.IUserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.springframework.http.HttpStatus

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class UserServiceTest {

    private val defaultUserName = "TestUser"
    private val defaultName = "First Last"
    private val defaultEmail = "dev@asrr.nl"

    @Test
    fun `create should throw exception if user already exists`() {
        val repository = mockk<IUserRepository>()
        every { repository.existsByUserName(any()) } returns true
        val service = createService(repository)

        assertThrows<UserAlreadyExistsException> { service.create(createDefaultUser()) }
    }

    @Test
    fun `create on success should return success statuscode`() {
        val repository = mockk<IUserRepository>()
        every { repository.existsByUserName(any()) } returns false
        every { repository.save(any()) } returns User(defaultUserName, defaultName, defaultEmail)
        val service = createService(repository)

        val created = service.create(createDefaultUser())

        assertEquals(HttpStatus.CREATED, created.statusCode)
    }

    private fun createService(repository: IUserRepository = mockk()): UserService {
        return UserService(repository)
    }

    private fun createDefaultUser(): UserCreationDto {
        return UserCreationDto(defaultUserName, defaultName, defaultEmail)
    }
}
