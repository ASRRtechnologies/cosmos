package nl.asrr.cosmos.user.service

import nl.asrr.common.id.IdGenerator
import nl.asrr.cosmos.user.dto.UserCreationDto
import nl.asrr.cosmos.user.exception.UserAlreadyExistsException
import nl.asrr.cosmos.user.model.User
import nl.asrr.cosmos.user.repository.IUserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: IUserRepository, val idGenerator: IdGenerator) {

    fun create(userDto: UserCreationDto): ResponseEntity<User> {
        val (username, name, email) = userDto
        val id = idGenerator.generate()

        if (exists(username)) throw UserAlreadyExistsException(username)
        val user = User(id, username, name, email)

        return ResponseEntity(userRepository.save(user), HttpStatus.CREATED)
    }

    fun exists(username: String): Boolean {
        return userRepository.existsByUserName(username)
    }
}
