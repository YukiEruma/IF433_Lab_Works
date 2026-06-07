package oop_107874_renaldi.week13

import java.io.File

fun main() {
    println("=== TEST UNSAFE RESOURCE HANDLING ===")
    val unsafeFile = File(pathname = "unsafe_logs.txt")

    val writer = unsafeFile.printWriter()

    writer.println("Log 1: Membuka koneksi database...")
    writer.println("Log 2: Menulis data pengguna...")


    writer.close()
    println("Proses penulisan unsafe selesai.")
}
