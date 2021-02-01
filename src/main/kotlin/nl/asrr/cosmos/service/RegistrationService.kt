package nl.asrr.cosmos.service

import nl.asrr.cosmos.dto.EmployeeDto
import nl.asrr.cosmos.model.Employee
import nl.asrr.cosmos.model.Entry
import nl.asrr.cosmos.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class RegistrationService(
    private val employeeRepository: EmployeeRepository
) {

    fun register(request: EmployeeDto): Employee {
        val entry = Entry("Default", "General", mutableListOf())

        return employeeRepository.save(Employee(
            name = request.name,
            entries = mutableListOf(entry)
        ))
    }

}