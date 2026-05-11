package oop_107874_renaldi.week02

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("Masukkan Nama Hero: ")
    val name = scanner.nextLine()

    print("Masukkan Base Damage Hero: ")
    val damage = scanner.nextLine().toIntOrNull() ?: 0

    val hero = Hero(name, damage)
    var enemyHp = 100

    while (hero.isAlive() && enemyHp > 0) {
        println("\nMenu:")
        println("1. Serang")
        println("2. Kabur")
        print("Pilih aksi: ")
        val input = scanner.nextLine()
        val action = input.toIntOrNull()

        if (action == null) {
            println("Input tidak valid! Masukkan angka 1 atau 2.")
            continue
        }

        if (action == 1) {
            hero.attack("Musuh")
            enemyHp -= hero.baseDamage
            println("Sisa HP Musuh: $enemyHp")

            if (enemyHp > 0) {
                val enemyDamage = (10..20).random()
                println("Musuh membalas serangan dengan damage $enemyDamage!")
                hero.takeDamage(enemyDamage)
                println("Sisa HP Hero: ${hero.hp}")
            }
        } else if (action == 2) {
            println("${hero.name} melarikan diri dari pertempuran!")
            break
        } else {
            println("Aksi tidak valid.")
        }
    }

    println("\n--- Hasil Pertempuran ---")
    if (!hero.isAlive()) {
        println("Musuh Menang! ${hero.name} telah dikalahkan.")
    } else if (enemyHp <= 0) {
        println("${hero.name} Menang! Musuh telah dikalahkan.")
    } else {
        println("Pertempuran berakhir karena ${hero.name} kabur.")
    }
}