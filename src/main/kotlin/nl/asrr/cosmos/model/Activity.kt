package nl.asrr.cosmos.model

import com.rabbitmq.client.LongString
import java.time.Duration

data class Activity(
    val title: String,
    val description: LongString,
    val time: Duration
)