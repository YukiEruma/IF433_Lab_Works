package oop_107874_renaldi.week06

class SmartCCTV(override val id: String, override val name: String) : SmartDevice, Switchable, Recordable {
    override fun turnOn() {
        println("[$name] CCTV menyala.")
        startRecord()
    }

    override fun turnOff() {
        println("[$name] CCTV dimatikan.")
    }

    override fun startRecord() {
        println("[$name] Perekaman dimulai.")
    }
}