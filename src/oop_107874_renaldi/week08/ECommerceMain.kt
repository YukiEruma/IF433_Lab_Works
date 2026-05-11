package oop_107874_renaldi.week08

fun main() {
    val rawApiData: List<Map<String, Any?>> = listOf(
        mapOf("id" to "E01", "name" to "Laptop", "type" to "ELECTRONIC", "warranty" to 24),
        mapOf("id" to "C01", "name" to "T-Shirt", "type" to "CLOTHING", "size" to "XL"),
        mapOf("id" to "E02", "name" to "Mouse", "type" to "ELECTRONIC", "warranty" to "Not An Integer"),
        mapOf("name" to "Ghost Item", "type" to "CLOTHING"),
        mapOf("id" to "X01", "name" to "Unknown", "type" to "FOOD")
    )

    val parser = ApiParser()

    for (raw in rawApiData) {
        try {
            val product = parser.parseProduct(raw)
            product?.let {
                when (it) {
                    is Product.Electronic -> println("Electronic: ${it.name} | Warranty: ${it.warrantyMonths} bulan")
                    is Product.Clothing -> println("Clothing: ${it.name} | Size: ${it.size}")
                }
                parser.checkout(it)
            } ?: println("SKIP: Tipe produk tidak dikenal.")
        } catch (e: IllegalArgumentException) {
            println("LOG WARNING: Data korup diabaikan. Alasan: ${e.message}")
        }
    }
}