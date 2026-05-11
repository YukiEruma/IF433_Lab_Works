package oop_107874_renaldi.week07

class Weapon private constructor(val item: GameItem, val durability: Int) {
    companion object {
        fun forgeStarterSword(): Weapon {
            return Weapon(
                item = GameItem("Pedang Kayu Bapuk", 5, ItemRarity.COMMON),
                durability = 50
            )
        }

        fun forgeEpicSword(): Weapon {
            return Weapon(
                item = GameItem("Pedang Naga Api", 500, ItemRarity.EPIC),
                durability = 200
            )
        }
    }
}