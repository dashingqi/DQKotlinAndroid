package com.dashingqi.kotlinproject.标准函数

import java.lang.StringBuilder

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 */

fun main() {
    var fruits = listOf<String>("Apple", "Banana", "Orange", "Pear")

//    val builder = StringBuilder()
//    builder.append("Start ear fruit \n")
//    for (fruit in fruits) {
//        builder.append(fruit).append("\n")
//    }
//    builder.append("Eat all fruits")
//    val result = builder.toString()
//    println(result)

    // 使用标准函数with来简化
//    val withResult = with(StringBuilder()) {
//        append("Start ear fruit \n")
//        for (fruit in fruits) {
//            append(fruit).append("\n")
//        }
//        append("Eat all fruits")
//        toString()
//    }
//    println("$withResult")

    // 使用标准函数run来简化
//    val result = StringBuilder().run {
//        append("Start ear fruit \n")
//        for (fruit in fruits) {
//            append(fruit).append("\n")
//        }
//        append("Eat all fruits")
//        toString()
//    }
//    println("result = $result")

    //使用标准函数apply来简化
    val resultSb = StringBuilder().apply {
        append("Start ear fruit \n")
        for (fruit in fruits) {
            append(fruit).append("\n")
        }
        append("Eat all fruits")

    }
    println("resultSb = ${resultSb.toString()}")

    /**
     * let函数最常用就是需要对一个可null的对象做统一的非空处理
     */
    var result = "Hello".let {
        println("${it.length}")
        1000
    }



    println("result = $result")
}