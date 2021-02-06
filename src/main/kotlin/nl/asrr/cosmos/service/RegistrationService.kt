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
        val (name) = request;

        if (employeeRepository.existsByName(name)) throw Exception("Employee not unique")

        return employeeRepository.save(
            Employee(
                name = name
            )
        )
    }

    fun getDefaultEntries(): MutableList<Entry> = mutableListOf(
        Entry("Communications", "General", mutableListOf()),
        Entry("General", "General", mutableListOf()),
        Entry("Development", "Front-End", mutableListOf()),
        Entry("Default", "Back-End", mutableListOf())
    )

}