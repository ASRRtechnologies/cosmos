package nl.asrr.cosmos.dto

import java.time.Duration

data class ActivityCreationDto(val fieldName: String, val activityName: String, val duration: Duration)