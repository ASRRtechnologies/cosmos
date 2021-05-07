package nl.asrr.cosmos.controller

import io.swagger.v3.oas.annotations.Operation
import nl.asrr.cosmos.dto.UserCreationDto
import nl.asrr.cosmos.model.User
import nl.asrr.cosmos.repository.UserRepository
import nl.asrr.cosmos.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userRepository: UserRepository,
    private val userService: UserService
) {

    @GetMapping
    @Operation(summary = "Retrieve all users", description = "This call retrieves all users without a filter.")
    fun getAllProjects(): ResponseEntity<List<User>> {
        val projects = userRepository.findAll()
        return ResponseEntity.ok(projects)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve user by id", description = "This call retrieves a user by id.")
    fun getOneProject(@PathVariable("id") id: String): ResponseEntity<User> {
        val user = userRepository.findOneById(id)
        return ResponseEntity.ok(user)
    }

    @PostMapping
    @Operation(summary = "Create new user")
    fun createProject(@RequestBody userCreationDto: UserCreationDto): ResponseEntity<User> {
        return userService.create(userCreationDto)
    }
}
