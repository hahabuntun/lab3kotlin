fun main() {
//    val trickFunction = ::trick
//    val trickFunction = trick
//    trickFunction()
//    treat()

    val coins: (Int) -> String = {
        quantity -> "$quantity quarters"
    }
    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)
    val example = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
    example()
}

//fun trick() {
//    println("No treats!")
//}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick){
        return trick
    }
    else{
        if (extraTreat != null){
            print(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}