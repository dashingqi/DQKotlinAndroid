package com.dashingqi.kotlinproject.面向对象.数据类

/**
 * @author : zhangqi
 * @time : 2020/4/4
 * desc : 在类之前声明 data关键字 用来表达式当前类是一个数据类
 * Kotlin会根据主构造函数中的参数帮你将equals()，hashCode(),toString()自动完成
 *如果不用 data的话 就变味了
 */
data class CellPhone(val brand:String,val price:Double)