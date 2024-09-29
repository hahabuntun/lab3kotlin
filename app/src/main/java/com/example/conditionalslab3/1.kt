fun main() {
    println(1 == 1)
    println(1 <= 1)
    println(1 < 1)
    println(1 > 1)
    println(1 >= 1)
    println(1 != 1)
    val trafficLightColor = "Black"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else if (trafficLightColor == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }
}