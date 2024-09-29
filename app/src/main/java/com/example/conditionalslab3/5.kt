class SmartDevice {
    val name = "Android TV"
    val category = "Entertainment"
    var deviceStatus = "online"
    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
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
    val smartTvDevice = SmartDevice();
    println("Device name is: ${smartTvDevice.name}")
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}