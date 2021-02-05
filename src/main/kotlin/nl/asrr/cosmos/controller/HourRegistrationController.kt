package nl.asrr.cosmos.controller

import nl.asrr.cosmos.model.Activity
import nl.asrr.cosmos.model.Employee
import nl.asrr.cosmos.model.Entry
import nl.asrr.cosmos.service.ActivityService
import nl.asrr.cosmos.service.RegistrationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.http.HttpResponse

@RestController
class HourRegistrationController (private val activityService: ActivityService){

    @GetMapping("/test")
    fun hours(): String {
        return "hi"
    }

    @PostMapping("/{employeeName}")
    fun add(@RequestBody request: Entry, @PathVariable employeeName: String): ResponseEntity<Employee> {
        return ResponseEntity(activityService.create(request, employeeName), HttpStatus.CREATED)
    }

}