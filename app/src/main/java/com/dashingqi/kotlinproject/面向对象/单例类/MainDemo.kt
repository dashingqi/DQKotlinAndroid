package com.dashingqi.kotlinproject.面向对象.单例类

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 */

fun main() {
    //单例类中的方法调用，类似于Java中的静态方法的调用
    //背后其实是Kotlin自动帮我们创建了一个Singleton类的实例，并且保证全局只会存在一个Singleton实例
    Singleton.singletonTest()
}