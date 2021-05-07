//package nl.asrr.cosmos.service
//
//import nl.asrr.cosmos.model.User
//import nl.asrr.cosmos.repository.UserRepository
//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.TestInstance
//import org.junit.jupiter.api.extension.ExtendWith
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.test.web.client.TestRestTemplate
//import org.springframework.boot.web.server.LocalServerPort
//import org.springframework.test.context.junit.jupiter.SpringExtension
//
//@ExtendWith(SpringExtension::class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//internal class UserServiceTest @Autowired constructor(
//    private val userRepository: UserRepository,
//    private val restTemplate: TestRestTemplate
//) {
//    private val defaultProjectId = "id1"
//
//    @LocalServerPort
//    protected var port: Int = 0
//
//    @BeforeEach
//    fun setUp() {
//        userRepository.deleteAll()
//    }
//
//    private fun getRootUrl(): String = "http://localhost:$port/api/v1/user"
//
//    private fun saveOneUser() = userRepository.save(
//        getUser()
//    )
//
//    private fun getUser() = User(
//        "Amar_97",
//        "Amar",
//        "contact@asrr.nl",
//    )
//
//    @Test
//    fun `should return all users`() {
//        saveOneUser()
//
//        val response = restTemplate.getForEntity(
//            getRootUrl(),
//            List::class.java
//        )
//
//        Assertions.assertEquals(200, response.statusCode.value())
//        Assertions.assertNotNull(response.body)
//        Assertions.assertEquals(1, response.body?.size)
//    }
//}
