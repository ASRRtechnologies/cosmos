package nl.asrr.cosmos.model

data class Entry(
    var project: String,
    var field: String,
    var activities: MutableList<Activity>
)

