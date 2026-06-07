package oop_107874_renaldi.week14

class MySQLDatabase {
    fun query(sql: String): List<String> = listOf("data1", "data2")
}

class UserService {
    private val database = MySQLDatabase() // Hard-coded! Tightly coupled!
    fun getUser(id: Int) = database.query("SELECT * FROM users WHERE id=$id")
}