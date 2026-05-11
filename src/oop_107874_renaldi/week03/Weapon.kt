package oop_107874_renaldi.week03

class Weapon(val name: String) {

    var damage: Int = 0
        set(value) {
            if (value < 0) {
                println("WARNING: Damage tidak boleh negatif! Nilai tidak diubah.")
                // field tidak diubah, tetap nilai lama
            } else if (value > 1000) {
                println("WARNING: Damage terlalu besar! Dipaksa menjadi 1000.")
                field = 1000
            } else {
                field = value
            }
        }

    val tier: String
        get() = when {
            damage > 800 -> "Legendary"
            damage > 500 -> "Epic"
            else -> "Common"
        }
}