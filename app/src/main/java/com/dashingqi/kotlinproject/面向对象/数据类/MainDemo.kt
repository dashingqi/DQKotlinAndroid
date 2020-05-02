package com.dashingqi.kotlinproject.面向对象.数据类

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 */

fun main() {
    val cellPhone = CellPhone("HW", 1299.9)
    val cellPhone1 = CellPhone("HW", 1299.9)
    println(cellPhone)
    println("cellPhone equals cellPhone1 ${cellPhone == cellPhone1}")

}