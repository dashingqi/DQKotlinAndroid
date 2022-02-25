package com.dashingqi.activitydemo

/**
 * @author zhangqi61
 * @since 2021/12/21
 */
private const val TAG = "ArrayDemo"

class ArrayDemo {
    fun arrayMethod() {
        val array = arrayOf(1, 2, 3)
        array.forEach {
            println("it --> $it")
        }
    }
}