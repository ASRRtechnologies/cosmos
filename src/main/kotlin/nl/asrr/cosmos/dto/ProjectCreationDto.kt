package nl.asrr.cosmos.dto

import java.time.Duration

data class ProjectCreationDto(val name: String, val client: String, val budget: Int?)

data class ActivityCreationDto(val fieldName: String, val activityName: String, val duration: Duration)
