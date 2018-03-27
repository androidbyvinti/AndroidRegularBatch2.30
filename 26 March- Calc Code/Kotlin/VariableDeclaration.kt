
// public static void main(String args[])


// fun print(v: Int){

//}

fun main(a: Array<String>) {

    var first = 1   // mutable property
    val second = 54 // immutable property

    //second++      // will give error as second is immutable

    var kotlin : String = "kotlin"  // explicit type declaration
    var present = false

    //var name1 : String?  = null   // null or value -> operator --> datatype
    //name1 = "ram"


    // null variable declaration
    var name = "ram kumar"
    //var name : String? = "ram kumar"  // ? used for declaring nullable types

    // name = null // will give error as not declared with null type

    // Any type declaration with Kotlin
    var elements : Any = 54
    elements = "data"

    // local variables need to be initialized
    //    var d : Int
    //    println(d)

    // String Template
    var value = "value is $first"
    println("Hello $kotlin")

}