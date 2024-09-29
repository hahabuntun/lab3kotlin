fun main(){
    val trafficLightColor = "Green"

    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }

    val x = 3

    when (x) {
        2 -> println("x is a prime number between 1 and 10.")
        3 -> println("x is a prime number between 1 and 10.")
        5 -> println("x is a prime number between 1 and 10.")
        7 -> println("x is a prime number between 1 and 10.")
    }

    val y = 3

    when (y) {
        2, 3, 5, 7 -> println("y is a prime number between 1 and 10.")
        else -> println("y isn't a prime number between 1 and 10.")
    }


    val z = 3

    when (z) {
        2, 3, 5, 7 -> println("z is a prime number between 1 and 10.")
        in 1..10 -> println("z is a number between 1 and 10, but not a prime number.")
        else -> println("z isn't a prime number between 1 and 10.")
    }

    val h: Any = 20

    when (h) {
        2, 3, 5, 7 -> println("h is a prime number between 1 and 10.")
        in 1..10 -> println("h is a number between 1 and 10, but not a prime number.")
        is Int -> println("h is an integer number, but not between 1 and 10.")
        else -> println("h isn't an integer number.")
    }
}