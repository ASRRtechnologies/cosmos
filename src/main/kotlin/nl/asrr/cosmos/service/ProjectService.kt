package nl.asrr.cosmos.service

import nl.asrr.cosmos.dto.EmployeeDto
import nl.asrr.cosmos.model.Activity
import nl.asrr.cosmos.model.Employee
import nl.asrr.cosmos.model.Entry
import nl.asrr.cosmos.repository.EmployeeRepository
import nl.asrr.cosmos.repository.ProjectRepository
import org.springframework.stereotype.Service


@Service
class ProjectService(
    private val projectRepository: ProjectRepository
) {

    fun create(): Int {
        var a = 3
        return a
    }

}