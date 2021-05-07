package nl.asrr.cosmos.app.model.portfolio

data class Category(
    var name: String,
    var accounts: List<Account>?
)
