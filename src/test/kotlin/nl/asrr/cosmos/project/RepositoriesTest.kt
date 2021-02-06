//package nl.asrr.cosmos.project
//
//import nl.asrr.cosmos.model.Employee
//import nl.asrr.cosmos.repository.ProjectRepository
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
//
//@DataJpaTest
//class RepositoriesTest @Autowired constructor(
//    val entityManager: TestEntityManager,
//    val userRepository: ProjectRepository) {
//
////    @Test
////    fun `When findByIdOrNull then return Article`() {
////
////
////        val juergen = User("springjuergen", "Juergen", "Hoeller")
////        entityManager.persist(juergen)
////        val article = Article("Spring Framework 5.0 goes GA", "Dear Spring community ...", "Lorem ipsum", juergen)
////        entityManager.persist(article)
////        entityManager.flush()
////        val found = articleRepository.findByIdOrNull(article.id!!)
////        assertThat(found).isEqualTo(article)
////    }
//
//@Test
//    fun `When findByLogin then return User`() {
//        val john = Project("john")
//
//
//    val juergen = User("springjuergen", "Juergen", "Hoeller")
//        entityManager.persist(juergen)
//        entityManager.flush()
//        val user = userRepository.findByLogin(juergen.login)
//        assertThat(user).isEqualTo(juergen)
//    }
//}