
// class WhenUseKt{

fun main(args: Array<String>) {

    //Switch are not used in Kotlin. Instead of switch we have when
    var userValue = 't'

    //case 'a':
    // break

    when (userValue) { // 't' == 'a'
        'a' -> println("vowel")
        'e' -> println("vowel")
        'i' -> println("vowel")
        'o' -> println("vowel")
        'u' -> println("vowel")
        else -> println("consonant")
    }


    // more concise
    when (userValue) {
        'a', 'e', 'i' , 'o', 'u' -> println("vowel")
        else -> println("consonant")
    }

    // check which one is greater out of three
    val first =10
    val second = 20
    val third = 30

    when{

        first>second && second > third -> println("First is greater")
        second>third -> println("Second is greater")
        else -> println("Third is greater")
    }

    val max: Int

    max = when{
        first > second -> first
        else-> second
    }
    println(max)
}