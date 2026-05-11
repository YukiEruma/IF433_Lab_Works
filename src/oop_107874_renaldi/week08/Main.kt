package oop_107874_renaldi.week08

fun main() {
    // CP4 - Safe Calls & Elvis
    println("=== TEST SAFE CALLS & ELVIS ===")
    val emptyOrder = Order(null, null)
    val destination = emptyOrder.deliveryDetails?.address?.city?.name ?: "Kota Tidak Diketahui"
    println("Tujuan pengiriman: $destination")

    // CP5 - Safe Call + let
    println("\n=== TEST LET BLOCK ===")
    val validOrder = Order(null, 250000)
    val receipt = validOrder.totalPrice?.let { price ->
        val tax = price * 0.11
        "Transaksi Valid. Harga: Rp$price, Pajak: Rp$tax"
    } ?: "Transaksi Invalid: Harga belum di-set!"
    println(receipt)

    // CP6 & CP7 - Mixed Collection & Safe Casting
    println("\n=== TEST SAFE CASTING ===")
    val mixedData: List<Any> = listOf(
        "Smartphone",
        1500000,
        UserProfile("Andi", null),
        "Laptop",
        4500000.0
    )
    for (item in mixedData) {
        val text = item as? String
        text?.let {
            println("Ditemukan teks: ${it.uppercase()}")
        }
    }

    // CP8 - Safe Cast + Elvis Fallback
    val someObject: Any = 100
    val safeString = someObject as? String ?: "Unknown String"
    println("Hasil cast + fallback: $safeString")

    // CP10 - The Red Button (!!)
    println("\n=== TEST THE RED BUTTON (!!) ===")
    val toxicData: String? = null
    try {
        val length = toxicData!!.length
    } catch (e: NullPointerException) {
        println("CRASH (NPE)! Jangan gunakan !! secara sembarangan.")
    }

    // CP11 - requireNotNull
    val apiResponse: Map<String, String?> = mapOf("status" to "200", "token" to null)
    try {
        val token = requireNotNull(apiResponse["token"]) {
            "CRITICAL EXCEPTION: Token otentikasi tidak ditemukan dari server!"
        }
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    // CP13 - Java Interop
    println("\n=== TEST JAVA INTEROP ===")
    val javaResponse = LegacyJavaAPI.fetchServerStatus()
    val statusLength = javaResponse!!.length
    println("Status dari Java: $javaResponse (Length: $statusLength)")

    // CP14 - Unit Test
    runMockUnitTest()
}