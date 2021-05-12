package nl.asrr.cosmos.user.service

import nl.asrr.cosmos.user.dto.UserCreationDto
import nl.asrr.cosmos.user.exception.UserAlreadyExistsException
import nl.asrr.cosmos.user.model.User
import nl.asrr.cosmos.user.repository.IUserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: IUserRepository) {

    fun create(userDto: UserCreationDto): ResponseEntity<User> {
        val (username, name, email) = userDto

        if (exists(username)) throw UserAlreadyExistsException(username)
        val user = User("1234", username, name, email)

        return ResponseEntity(userRepository.save(user), HttpStatus.CREATED)
    }

    fun exists(username: String): Boolean {
        return userRepository.existsByUserName(username)
    }
}
