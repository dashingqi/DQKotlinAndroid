package com.dashingqi.kotlinproject.Lambda编程

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 */

fun main() {
    //常规的用法
//    val list = ArrayList<String>()
//    list.add("Apple")
//    list.add("Banana")
//    list.add("Orange")
    //kotlin内置的listOf()函数来简化初始化集合的写法
    // 其中listOf方法创建的集合是不可变的集合，就是不能进行添加，删除，替换的操作
//    val lists = listOf<String>("apple", "banana", "orange")
//    for (fruit in lists) {
//        println("fruit = ${fruit}")
//    }
    //创建一个可变的集合 使用mutableListOf()方法
//    var mutableListOf = mutableListOf<String>("apple", "banana", "orange")
//    mutableListOf.add("Hei")
//    for (fruit in mutableListOf) {
//        println(fruit)
//    }
    //创建Set集合的用法是和List几乎是一样
    //使用setOf()创建不可变集合，mutableSetOf()函数创建一个可变Set集合
    //Set采用的是hash映射机制存放数据，所以不是按照顺序存放的，List是按照顺序存放的，这和他们的底层实现的数据结构有关

    //Map集合
    //Java式的写法
    val map = HashMap<String, Int>()
    map.put("apple", 1)
    map.put("orange", 2)
    map.put("banana", 3)
    //Kotlin中不建议使用put和get方法来对Map进行添加和读取的操作，而是推荐使用一种类似于数组下标的语法
    map["heihie"] = 5
    //从map中读取一条数据
    val number = map["apple"]
    //上述代码经过优化可以写成如下
    val map1 = HashMap<String, Int>()
    map1["apple"] = 1
    map1["orange"] = 2
    map1["banana"] = 3

    // 上述还不是最简便的写法 还是提供了mapOf()和mutableMapOf()方法来继续简化Map的用法
    //使用mapOf
    val map2 = mapOf<String, Int>("apple" to 1, "orange" to 2, "banana" to 3)
    //我们使用for-in来遍历去除map2中的数据
    for ((fruit, number) in map2) {
        println("fruit is ${fruit},number is ${number}")
    }

}