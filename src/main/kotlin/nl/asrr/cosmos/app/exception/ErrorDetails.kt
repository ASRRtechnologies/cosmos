package nl.asrr.cosmos.app.exception

import java.util.Date

data class ErrorDetails(val time: Date, val message: String, val details: String)
