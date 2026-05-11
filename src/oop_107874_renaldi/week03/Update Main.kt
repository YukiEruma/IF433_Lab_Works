package oop_107874_renaldi.week03

fun main() {
    val e = Employee("Budi")


    e.salary = -1000
    e.salary = 5000000
    println("Gaji: ${e.salary}")


    e.increasePerformance()


    println("Pajak yang harus dibayar: ${e.tax}")

    println("\n--- Test Weapon ---")
    val sword = Weapon("Excalibur")
    sword.damage = -50
    sword.damage = 9999
    println("Damage: ${sword.damage}, Tier: ${sword.tier}")

    println("\n--- Test Player ---")
    val player = Player("Renaldi")

    player.addXp(50)
    player.addXp(60)
    println("Level sekarang: ${player.level}")
}