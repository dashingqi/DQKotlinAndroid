package com.dashingqi.kotlinproject.Lambda编程.集合的函数式API

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc :
 * 需求1：在一个水果集合中找到名字最长的那个
 */

fun main() {
    //Java式的思想
    val fruitList = listOf<String>("Apple", "Orange", "Pear", "Banana")
//    var maxLengthFruit = ""
//    for (fruit in fruitList) {
//        if (fruit.length > maxLengthFruit.length) {
//            maxLengthFruit = fruit
//        }
//    }
//    println("max length fruit is ${maxLengthFruit}")
//
//    //使用了函数式API
//    val maxLength = fruitList.maxBy { it.length }
//    println("max length fruit is ${maxLength}")
//
//    // map函数
    val newList = fruitList.map { it.toUpperCase() }
    for (fruit in newList) {
        println("fruit is ${fruit}")
    }

    // filter函数
    /**
     * 将集合中长度大于5的提取出来
     */
    val newLists = fruitList.filter { it.length >= 5 }
        .map { it.toUpperCase() }

    for (fruit in newLists) {
        println(fruit)
    }

    //any和all函数
    //其中any函数是用来判断集合是否至少存在一个元素满足指定条件。
    // all函数是用来判断集合中是否所有元素都满足指定条件

    //是否存在长度大于5的
    val anyResult = fruitList.any { it.length >= 5 }
    //是否所有的长度都大于5
    val allResult = fruitList.all { it.length >= 5 }
    println("anyResult is ${anyResult}, allResult is ${allResult}")

}