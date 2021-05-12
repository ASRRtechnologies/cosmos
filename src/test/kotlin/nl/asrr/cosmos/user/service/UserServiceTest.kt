package nl.asrr.cosmos.user.service

import io.mockk.every
import io.mockk.mockk
import nl.asrr.common.id.IdGenerator
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

    private val defaultId = "id"
    private val defaultUserName = "TestUser"
    private val defaultName = "First Last"
    private val defaultEmail = "dev@asrr.nl"

    @Test
    fun `create should throw exception if user already exists`() {
        val repository = mockk<IUserRepository>()
        every { repository.existsByUserName(any()) } returns true
        val service = createService(repository)

        assertThrows<UserAlreadyExistsException> { service.create(createDefaultUserCreationDto()) }
    }

    @Test
    fun `create on success should return success statuscode`() {
        val repository = mockk<IUserRepository>()
        every { repository.existsByUserName(any()) } returns false
        every { repository.save(any()) } returns createDefaultUser()
        val service = createService(repository)

        val created = service.create(createDefaultUserCreationDto())

        assertEquals(HttpStatus.CREATED, created.statusCode)
        assertEquals(defaultId, created.body!!.id)
    }

    private fun createService(repository: IUserRepository = mockk(), idGenerator: IdGenerator = mockk()): UserService {
        every { idGenerator.generate() } returns defaultId
        return UserService(repository, idGenerator)
    }

    private fun createDefaultUserCreationDto(): UserCreationDto {
        return UserCreationDto(defaultUserName, defaultName, defaultEmail)
    }

    private fun createDefaultUser(): User {
        return User(defaultId, defaultUserName, defaultName, defaultEmail)
    }
}
