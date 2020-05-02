package com.dashingqi.kotlinproject.面向对象

import com.dashingqi.kotlinproject.面向对象.接口.Study

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 * Kotlin中 使用 冒号 : 来表明继承关系
 * 主构造函数是没有函数体，直接定义在类名后面就可以、
 * 子类中的构造函数必须调用父类中的构造函数 所以继承的时候 Person()
 * 在主构造函数中声明成val和var的参数将自动成为该类的字段
 */
class Student(name: String, age: Int) : Person(name, age), Study {
    //如果想在主构造函数中编写逻辑，可以使用init结构体
//    init {
//        println("name is ${name}")
//    }

    override fun readBooks() {
        println("name is ${name}")
    }

    /**
     * 在接口Study中，doHomework函数有默认的实现，
     * 这里可以不用强制重写 doHomework方法
     */
//    override fun doHomework() {
//        println("age is ${age}")
//    }
}