package com.dashingqi.kotlinproject.面向对象.接口

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 */
interface Study {
    fun readBooks()
    //如果接口中一个函数拥有了函数体，这个函数中的内容就是它的默认实现。
    fun doHomework() {
        println("do homework default implementation")
    }
}