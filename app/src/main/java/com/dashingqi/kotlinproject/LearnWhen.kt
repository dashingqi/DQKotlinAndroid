package com.dashingqi.kotlinproject

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc : 输入一个名字查询成绩
 */
fun main() {
    val a = 10L
    checkNumber(a);
}

fun useIf(name: String) = if (name == "Tom") {
    78
} else if (name == "Jake") {
    67
} else {
    0
}

fun useWhen(name: String) = when (name) {
    "Tom" -> 78
    "Jake" -> 67
    else -> 0
}

//使用when进行类型匹配
fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("num is Int")
        is Double -> println("num is Double")
        else -> println(" number not support")
    }
}

/**
 * 不带参数的用法
 * 名字以Tom开头的
 */
fun getScore1(name: String) = when {
    name.startsWith("Tom") -> 56
    name == "Jack" -> 56
    else -> 0
}
