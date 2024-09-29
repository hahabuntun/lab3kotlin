fun main() {
    val favoriteActor = null
    println(favoriteActor)

    var favoriteActor2: String? = "Sandra Oh"
    favoriteActor2 = null
    println(favoriteActor2)

    var number: Int? = 10
    println(number)

    number = null
    println(number)

    var favoriteActor3: String? = "Sandra Oh"
    println(favoriteActor3?.length)

    var favoriteActor4: String? = "Sandra Oh"
    println(favoriteActor4!!.length)

    var favoriteActor5: String? = "Sandra Oh"

    if (favoriteActor5 != null) {
        println("The number of characters in your favorite actor's name is ${favoriteActor5.length}.")
    } else {
        println("You didn't input a name.")
    }


    var favoriteActor6: String? = "Sandra Oh"

    val lengthOfName = if (favoriteActor6 != null) {
        favoriteActor6.length
    } else {
        0
    }

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}