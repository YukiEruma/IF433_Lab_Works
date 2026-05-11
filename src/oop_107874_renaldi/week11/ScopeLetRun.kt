package oop_107874_renaldi.week11

fun main() {
    // CHECKPOINT 4 - let function
    println("=== TEST LET FUNCTION ===")
    val name: String? = "Alexander"

    val length = name?.let {
        println("Nama terdeteksi: $it")
        it.length
    } ?: 0
    println("Panjang nama: $length")

    // CHECKPOINT 5 - run function
    println("\n=== TEST RUN FUNCTION ===")
    val result = "Kotlin".run {
        println("Memproses kata: ${this}")
        this.length * 2
    }
    println("Hasil kalkulasi run: $result")
}