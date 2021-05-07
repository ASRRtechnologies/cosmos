package nl.asrr.cosmos.app.service

import nl.asrr.cosmos.app.repository.UserRepository
import nl.asrr.cosmos.user.dto.UserCreationDto
import nl.asrr.cosmos.user.exception.UserAlreadyExistsException
import nl.asrr.cosmos.user.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun create(userDto: UserCreationDto): ResponseEntity<User> {
        val (id, name, email) = userDto

        if (exists(id)) throw UserAlreadyExistsException(id)
        val user = User(id, name, email)

        return ResponseEntity(userRepository.save(user), HttpStatus.CREATED)
    }

    fun exists(id: String): Boolean {
        return userRepository.existsById(id)
    }
}
