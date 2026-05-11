package oop_107874_renaldi.week08

class ApiParser {
    fun parseProduct(rawJson: Map<String, Any?>): Product? {
        val id = requireNotNull(rawJson["id"] as? String) {
            "API Invalid: Missing ID"
        }
        val name = requireNotNull(rawJson["name"] as? String) {
            "API Invalid: Missing Name"
        }
        val type = rawJson["type"] as? String

        return when (type) {
            "ELECTRONIC" -> {
                val warranty = rawJson["warranty"] as? Int ?: 12
                Product.Electronic(id, name, warranty)
            }
            "CLOTHING" -> {
                val size = rawJson["size"] as? String ?: "All Size"
                Product.Clothing(id, name, size)
            }
            else -> null
        }
    }

    fun checkout(product: Product) {
        val id = when (product) {
            is Product.Electronic -> product.id
            is Product.Clothing -> product.id
        }
        val transactionId = JavaPaymentService.processPayment(id)!!
        println("Checkout berhasil! Transaction ID: $transactionId")
    }
}