package nl.asrr.cosmos.repository

import nl.asrr.cosmos.model.Employee
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface EmployeeRepository : MongoRepository<Employee, String> {
    fun findOneById(id: ObjectId): Employee
    fun findEmployeeBy(name: String): Employee
    override fun deleteAll()
}