class SmartDevice2(val name: String, val category: String) {
    var deviceStatus = "online"
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }


    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}

fun main() {
    SmartDevice2("Android TV", "Entertainment")
    SmartDevice2(name = "Android TV", category = "Entertainment")

}