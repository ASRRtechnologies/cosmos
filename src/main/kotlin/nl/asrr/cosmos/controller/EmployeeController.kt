package nl.asrr.cosmos.controller

import nl.asrr.cosmos.dto.EmployeeDto
import nl.asrr.cosmos.model.Employee
import nl.asrr.cosmos.service.RegistrationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/employee")
class EmployeeController (private val registrationService: RegistrationService){

    @PostMapping("/create")
    fun create(@RequestBody employeeDto: EmployeeDto): ResponseEntity<Employee> {
        return ResponseEntity(registrationService.register(employeeDto), HttpStatus.CREATED)
    }

    @PostMapping("/test")
    fun test(@RequestBody employeeDto: EmployeeDto): EmployeeDto {
        return employeeDto
    }

    @GetMapping("/get")
    fun hours(): String {
        return "hi"
    }

}