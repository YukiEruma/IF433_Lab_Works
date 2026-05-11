package oop_107874_renaldi.week11

fun main() {

    val homeDevices = mutableListOf<SmartDevice>()


    SmartDevice("Philips WiZ Living Room", "Lighting").apply {
        isOnline = true
        powerLoad = 12
    }.also {
        homeDevices.add(it)
    }


    SmartDevice("Ezviz Outdoor", "Camera").apply {
        isOnline = true
        powerLoad = 5
    }.also {
        println("(LOG) Kamera terhubung")
        homeDevices.add(it)
    }


    val acUnit = run {
        SmartDevice("Daikin Inverter (Kabel 3x2.5)", "HVAC", false, 800)
    }
    homeDevices.add(acUnit)
    homeDevices.add(SmartDevice("Picolo's Auto Feeder", "Pet Care", true, 10))


    val searchResult = homeDevices.find { it.category == "Camera" }
    searchResult?.let {
        println(it.diagnose())
    }


    with(homeDevices) {
        println("\n========================================")
        println("       SMART HOME DASHBOARD")
        println("========================================")
        println("Total Perangkat Terdaftar: ${this.size}")
        println("========================================")
    }


    val totalPower = homeDevices.run { sumOf { it.powerLoad } }
    println("Total Konsumsi Daya: $totalPower Watt")
    println("========================================")


    println("\n=== DIAGNOSTIK SEMUA PERANGKAT ===")
    homeDevices.forEach { device ->
        println(device.diagnose())
    }
    println("========================================")
    println("[OK] Smart Home Configuration Pipeline berhasil dijalankan!")
}