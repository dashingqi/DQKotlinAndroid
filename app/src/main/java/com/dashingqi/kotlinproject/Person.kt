package com.dashingqi.kotlinproject

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 */
class Person(
    //只读属性，生成一个字段和一个简单的getter
    var name: String,
    //可写属性，生成一个字段、一个getter和一个setter
    var age: Int
)