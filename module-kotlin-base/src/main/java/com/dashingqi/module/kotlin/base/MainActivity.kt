package com.dashingqi.module.kotlin.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //声明一个name属性
    private lateinit var name: String

    private val age: Int by lazy {

        println("init age params")
        9
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generic = Generic<String>()
        var genericClass = generic::class.java
        // genericClass name is = com.dashingqi.module.kotlin.base.Generic
        println("genericClass name is = ${genericClass.name}")

        // 我们获取一下范性信息
        genericClass.declaredFields.forEach {
            // declaredFields == t type == java.lang.Object
            println("declaredFields == ${it.name} type == ${it.type.name}")
        }

        // 结论：当泛型类被泛型擦除的时候，如果泛型类中的泛型<T>没有指定上限的话，泛型就会被替代成Object
        // 如果指定可上限，那么泛型<T>就会被替代成对应的上限类型
        //为什么会出现类型擦除：泛型这个概念是java1.5版本出现的，为了兼容之前的版本所以就出现了泛型擦除这个东西

        var list1 = ArrayList<String>()

        var list2 = ArrayList<Int>()

        // 结果返回true 因为是类型擦除的原因
        // 类型擦除是存在于编译阶段 在进入JVM之前会把范性相关的信息擦除掉，所以
        println("list1 == list2 ==  ${list1::class.java == list2::class.java}")
        println("list1 == ${list1::class.java}")
        println("list1 == ${list2::class.java}")

        println("age ====> $age")

        name = "123"

        setStr(null)

        testIn()
    }


    /**
     * 这里声明的String属性是不能存储 null引用（空类型的）
     * 如果想要str能存储null引用，就得在String后面加上 ?
     *
     */
    private fun setStr(str: String?): Int? {
        return str?.length
    }

    private fun testIn() {
        var index = 4
        var indexList = mutableListOf<Int>(0, 1, 2, 3)
        //用in来判断数字是否在区间内
        if (index in 0..6) {
            println("index --> $index in 0...6")
        }

        if (index in indexList) {
            println("index ------> $index in indexList")
        } else {
            println("index --------> $index not in indexList")
        }

        for (index in indexList.size downTo 0) {
            println("index =====> $index")

            /**
             * 2020-08-05 22:35:36.099 16881-16881/com.dashingqi.module.kotlin.base I/System.out: index =====> 4
            2020-08-05 22:35:36.099 16881-16881/com.dashingqi.module.kotlin.base I/System.out: index =====> 3
            2020-08-05 22:35:36.099 16881-16881/com.dashingqi.module.kotlin.base I/System.out: index =====> 2
            2020-08-05 22:35:36.099 16881-16881/com.dashingqi.module.kotlin.base I/System.out: index =====> 1
            2020-08-05 22:35:36.099 16881-16881/com.dashingqi.module.kotlin.base I/System.out: index =====> 0
             */
        }
    }


    /**
     * 在kotlin中Any关键字相当于Java中的Object，是任何类的基类
     */
    private fun testAny() {

    }

    /**
     * 数据类
     * 使用 data 修饰 class
     */
    private fun dataBean() {

    }

    /**
     * 在kotlin中，可以有多个构造函数，分为一级构造和二级构造函数，一级构造函数只能有一个，
     * 二级构造可以有多个，但是二级构造函数必须直接或者间接代理主构造函数
     * class Test(var name:String){
     *   constructor(var Name:String):this(name)
     * }
     *
     * 在主构造函数中不能书写代码。所以kotlin提供了init{}初始化模块 在这里可以书写类初始化时的代码
     */


    /**
     * 高阶函数
     * 就是函数的参数中时函数类型或者返回值类型时函数类型
     */


    /**
     * 闭包不是函数，闭包在逻辑上是封闭的，它使用自己内部的数据，用自己内部的逻辑进行处理，外部只能得到闭包的输出，无法输入，也无法干扰
     */
}
