package nl.asrr.cosmos.model

import java.time.Duration

data class Activity(
    val title: String,
    val description: String,
    val time: Duration
)