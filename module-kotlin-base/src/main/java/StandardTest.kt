import java.lang.StringBuilder

/**
 * @author : zhangqi
 * @time : 2020/8/9
 * desc :
 */

fun main() {
    //withMethodPreTest()

   // withMethodBeforeTest()

    applyMethodTest()
}

private fun withMethodPreTest() {
    val fruits = listOf<String>("apple", "banana", "orange", "pear")
    var builder = StringBuilder()
    for (values in fruits) {
        builder.append(values).append("\n")
    }

    println("fruits ===> ${builder.toString()}")
}

private fun withMethodBeforeTest() {
    val fruits = listOf<String>("apple", "banana", "orange", "pear")
    var fruitBuilder = StringBuilder()

    val result = with(fruitBuilder) {
        for (fruit in fruits) {
            append(fruit).append("\n")
        }

        toString()
    }

    println(result)
}

private fun applyMethodTest(){
    val fruits = listOf<String>("apple", "banana", "orange", "pear")
    var fruitBuilder = StringBuilder()
    fruitBuilder.apply {
        for (fruit in fruits){
            append(fruit).append("\n")
        }
    }

    println(fruitBuilder)
}