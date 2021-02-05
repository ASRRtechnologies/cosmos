package nl.asrr.cosmos.controller

import nl.asrr.cosmos.dto.EmployeeDto
import nl.asrr.cosmos.model.Employee
import nl.asrr.cosmos.service.RegistrationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController (private val registrationService: RegistrationService){


    @PostMapping("/create")
    fun create(@RequestBody employeeDto: EmployeeDto): ResponseEntity<Employee> {
        return ResponseEntity(registrationService.register(employeeDto), HttpStatus.CREATED)
    }

}