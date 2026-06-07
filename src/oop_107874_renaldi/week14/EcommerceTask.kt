package oop_107874_renaldi.week14

import java.io.File

class BadOrderProcessor {

    private val file = File("orders.csv")

    fun processOrder(itemName: String, basePrice: Double, customerType: String) {


        val finalPrice = when (customerType) {
            "REGULAR" -> basePrice
            "VIP" -> basePrice * 0.90 // Diskon 10%
            else -> basePrice
        }

        println("Memproses pesanan $itemName seharga $finalPrice")


        file.appendText("$itemName,$finalPrice,$customerType\n")


        println("Email terkirim: Pesanan $itemName Anda telah dikonfirmasi!")
    }
}