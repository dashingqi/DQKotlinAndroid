package com.dashingqi.kotlinproject

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 */

fun main() {
    //区间的概念 0 .. 10 [0,10] 两端都是闭区间
//    for (i in 0..10) {
//        println(" i == ${i}")
//    }

    // until关键字 实现 左闭右开 [0,10)
//    for (i in 0 until 10) {
//        println("i == ${i}")
//    }

    // for-in 执行循环会在区间范围内递增1
    // 如果你想跳过其中一些元素 可以使用step关键字
    //会在区间范围内递增2 相当于 java中的 i = i + 2；
//    for (i in 0 until 10 step 2) {
//        println("i = ${i}")
//    }

    // until关键字是一个升序的过程，如果想要降序可以使用downTo关键字
    // [10,1] 是一个双端闭合的降序
    for (i in 10 downTo 1) {
        println("i = ${i}")
    }
}

