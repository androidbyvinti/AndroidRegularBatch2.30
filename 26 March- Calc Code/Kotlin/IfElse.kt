
fun main(args: Array<String>) {

    var first = 10

    var second = 34

    //var third : String = first

    var max = 0

    // same as in java

    // java valid code valid kotlin

    if(first > second)
        max = first

    else
        max = second


    // with kotlin
    max = if(first>second)
            first
        else
            second

    println(max)

    // As expression
    var maximum = if(first>second) first else second

    // with kotlin


//    max = if(first>second){
//        //var temp = 0
//        println("First is greater")
//        first       // return value must be in end when multiple statements are used
//    }
//    else {
//        println("Second is greater")
//        second
//    }
}