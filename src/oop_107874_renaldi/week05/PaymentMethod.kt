package oop_107874_renaldi.week05

abstract class PaymentMethod(val accountName: String) {
    abstract fun processPayment(amount: Double)
}