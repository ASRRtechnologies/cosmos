package nl.asrr.cosmos.model.portfolio

data class Category(
    var name: String,
    var accounts: List<Account>?
)
