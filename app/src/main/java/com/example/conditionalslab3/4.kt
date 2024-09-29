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
}