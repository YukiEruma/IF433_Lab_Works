package oop_107874_renaldi.week03

class Player(val username: String) {

    private var xp: Int = 0

    val level: Int
        get() = (xp / 100) + 1

    fun addXp(amount: Int) {
        if (amount <= 0) {
            println("ERROR: XP yang ditambahkan harus positif!")
            return
        }
        val levelSebelum = level
        xp += amount
        println("$username mendapat $amount XP. Total XP: $xp")
        if (level > levelSebelum) {
            println("Level Up! Selamat $username naik ke level $level")
        }
    }
}