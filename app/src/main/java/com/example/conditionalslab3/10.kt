fun main() {
//    val trickFunction = ::trick
    val trickFunction = trick
    trickFunction()
    treat()
}

//fun trick() {
//    println("No treats!")
//}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}