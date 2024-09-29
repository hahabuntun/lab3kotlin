import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}



open class SmartDevice5(val name: String, val category: String) {
    //private var deviceStatus = "online"
    var deviceStatus = "on"
        protected set

    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "off"
            1 -> "on"
            else -> "unknown"
        }
    }

    fun printDeviceInfo() {
        print("Device name: $name, category: $category, type: $deviceType")
    }


    open fun turnOn() {
        println("Smart device is turned on.")
    }

    open fun turnOff() {
        println("Smart device is turned off.")
    }
}


class SmartTvDevice3(deviceName: String, deviceCategory: String) :
    SmartDevice5(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
    fun previouseChanned() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice3(deviceName: String, deviceCategory: String) :
    SmartDevice5(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}


class SmartHome3(
    val smartTvDevice: SmartTvDevice3,
    val smartLightDevice: SmartLightDevice3
) {
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        if (smartTvDevice.deviceStatus == "off"){
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }

    }
    fun turnOffTv() {
        if (smartTvDevice.deviceStatus == "on"){
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }

    }
    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        }
    }

    fun decreaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on")
        {
            smartTvDevice.decreaseVolume()
        }
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on")
        {
            smartTvDevice.nextChannel()
        }
    }
    fun changeTvChannelToPrevious() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.previouseChanned()
        }
    }
    fun turnOnLight() {
        if (smartLightDevice.deviceStatus == "off") {
            smartLightDevice.turnOn()
        }
    }

    fun turnOffLight() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.turnOff()
        }
    }
    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        }
    }

    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        }
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
    fun printSmartTvInfo() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.printDeviceInfo()
        }
    }

    fun printSmartLightInfo() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.printDeviceInfo()
        }
    }
}

fun main() {
    val smartTvDevice = SmartTvDevice3("Android TV", "Entertainment")
    val smartLightDevice = SmartLightDevice3("Google Light", "Utility")
    val smartHome = SmartHome3(smartTvDevice, smartLightDevice)

    println("-------- Initial State --------")
    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    println("------------------------------")

    println("-------- Turn on TV --------")
    smartHome.turnOnTv()
    smartHome.printSmartTvInfo()
    println("------------------------------")

    println("-------- Increase TV Volume --------")
    smartHome.increaseTvVolume()
    smartHome.printSmartTvInfo()
    println("------------------------------")

    println("-------- Turn on Light --------")
    smartHome.turnOnLight()
    smartHome.printSmartLightInfo()
    println("------------------------------")

    println("-------- Increase Light Brightness --------")
    smartHome.increaseLightBrightness()
    smartHome.printSmartLightInfo()
    println("------------------------------")

    println("-------- Change TV Channel to Next --------")
    smartHome.changeTvChannelToNext()
    smartHome.printSmartTvInfo()
    println("------------------------------")

    println("-------- Decrease TV Volume --------")
    smartHome.decreaseTvVolume()
    smartHome.printSmartTvInfo()
    println("------------------------------")

    println("-------- Turn Off TV --------")
    smartHome.turnOffTv()
    smartHome.printSmartTvInfo()
    println("------------------------------")

    println("-------- Turn Off Light --------")
    smartHome.turnOffLight()
    smartHome.printSmartLightInfo()
    println("------------------------------")

    println("-------- Turn Off All Devices --------")
    smartHome.turnOffAllDevices()
    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    println("------------------------------")

    println("Device turn on count: ${smartHome.deviceTurnOnCount}")
}