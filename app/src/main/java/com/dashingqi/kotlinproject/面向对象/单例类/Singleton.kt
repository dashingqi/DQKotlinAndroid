package com.dashingqi.kotlinproject.面向对象.单例类

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 * Kotlin中的单例类只需要把class关键字改成object关键字，这样一个单例类就创建完成了。
 */
object Singleton {

    fun singletonTest(){
        println("singletonTest is called")
    }
}