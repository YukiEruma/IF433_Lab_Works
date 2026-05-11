package oop_107874_renaldi.week06

fun processCheckout(method: PaymentMethod, amount: Double) {
    println("-> Memulai checkout...")
    method.pay(amount)
}

fun main() {

    val myWatch = Smartwatch()
    myWatch.showTime()


    val myPhone = Smartphone()
    myPhone.turnOn()


    val pay1 = Gopay()
    val pay2 = CreditCard()

    println("\n=== TESTING CHECKOUT ===")
    processCheckout(method = pay1, amount = 50000.0)
    processCheckout(method = pay2, amount = 150000.0)


    println("\n=== SMART HOME SYSTEM ===")
    val lamp = SmartLamp(id = "L001", name = "Ruang Tamu")
    val speaker = SmartSpeaker(id = "S001", name = "Google Nest Dapur")
    val cctv = SmartCCTV(id = "C001", name = "Ezviz Garasi")

    val hub = SmartHomeHub()
    hub.addDevice(lamp)
    hub.addDevice(speaker)
    hub.addDevice(cctv)

    hub.activateSecurityMode()
    hub.turnOffAllSwitches()
}