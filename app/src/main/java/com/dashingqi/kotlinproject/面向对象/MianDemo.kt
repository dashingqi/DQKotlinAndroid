package com.dashingqi.kotlinproject.面向对象

import com.dashingqi.kotlinproject.面向对象.接口.Study


/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 */

fun main() {
    //抛弃了Java使用new关键字来创建类的实例
//    val person = Person()
//    person.age = 23
//    person.name = "Jack"
//    person.eat()

    val student = Student("123", 5)
    //多态编程的特性
    doStuStudy(student)
}

fun doStuStudy(study: Study) {
    study.doHomework()
    study.readBooks()
}