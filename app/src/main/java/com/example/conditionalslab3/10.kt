fun main() {
//    val trickFunction = ::trick
//    val trickFunction = trick
//    trickFunction()
//    treat()


    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)
    treatFunction()
    trickFunction()
}

//fun trick() {
//    println("No treats!")
//}

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick){
        return trick
    }
    else{
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}