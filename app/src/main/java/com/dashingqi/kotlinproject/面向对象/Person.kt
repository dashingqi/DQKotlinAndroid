package com.dashingqi.kotlinproject.面向对象

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 * 使用open关键字，那么Person就可以被继承了。
 */
open class Person(val name:String,val age:Int) {

    fun eat() {
        println("${name} is eating. He is ${age} years old")
    }
}