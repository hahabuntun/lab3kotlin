fun main() {
    println(1 == 1)
    println(1 <= 1)
    println(1 < 1)
    println(1 > 1)
    println(1 >= 1)
    println(1 != 1)
    val trafficLightColor = "Green"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else {
        println("Go")
    }
}