package nl.asrr.cosmos.service

import nl.asrr.cosmos.dto.EmployeeDto
import nl.asrr.cosmos.model.Activity
import nl.asrr.cosmos.model.Employee
import nl.asrr.cosmos.model.Entry
import nl.asrr.cosmos.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class ActivityService(
    private val employeeRepository: EmployeeRepository
) {

    fun create(request: Entry, employeeName: String): Employee {
        val employee = employeeRepository.findEmployeeBy(employeeName)
        employee.entries.add(request)
        return employeeRepository.save(employee)
    }

}