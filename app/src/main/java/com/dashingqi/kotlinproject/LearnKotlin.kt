package com.dashingqi.kotlinproject

import kotlin.math.max

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 */

fun main() {
    //类型推导机制
    val a = 10
    println("a = ${a}")
    println("Hello World")

    var b: Int = 56;
    b = b * 10;
    println("b = ${b}")
    val largerNumber = largerNumber(6, 8)
    println("largerNumber = ${largerNumber}")
}

fun largerNumber(a: Int, b: Int): Int {
    return max(a, b);
}

//自动类型推导
fun largerNumber1(a: Int, b: Int) = max(a, b)

//Java式的写法
fun largerNumber2(a: Int, b: Int): Int {
    var value = 0
    if (a > b) {
        value = a
    } else {
        value = b
    }
    return value
}

// if条件语句 在kotlin中是可以有返回值的，就是每一个条件中最后一行代码的返回值
fun largerNumber3(a: Int, b: Int): Int {
    val value = if (a > b) a else b
    return value
}

//在次简化
fun largerNumber4(a: Int, b: Int): Int {
    return if (a > b) a else b
}

//语法糖
fun largerNumber5(a: Int, b: Int) = if (a > b) a else b