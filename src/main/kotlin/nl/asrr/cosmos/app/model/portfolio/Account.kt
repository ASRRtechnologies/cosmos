package nl.asrr.cosmos.app.model.portfolio

import java.time.LocalDateTime

data class Account(
    var name: String,
    var value: Map<LocalDateTime, Double>
)
