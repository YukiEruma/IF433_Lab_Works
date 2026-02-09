package oop_107874_renaldi.week01

fun main() {
    val name = "Bambang"
    val score: Int? = 80

    val status = calculateStatus(score)

    println("Nama: $name")
    println("Nilai: ${score ?: "Tidak ada nilai"}")
    println("Status: $status")
}

fun calculateStatus(score: Int?): String =
    score?.let {
        when (it) {
            in 85..100 -> "A"
            in 70..84 -> "B"
            in 55..69 -> "C"
            else -> "D"
        }
    } ?: "Nilai belum diinput"
