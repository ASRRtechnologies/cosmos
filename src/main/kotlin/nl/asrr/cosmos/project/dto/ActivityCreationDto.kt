package nl.asrr.cosmos.project.dto

import java.time.Duration

data class ActivityCreationDto(
    val fieldName: String,
    val activityName: String,
    val duration: Duration
)
