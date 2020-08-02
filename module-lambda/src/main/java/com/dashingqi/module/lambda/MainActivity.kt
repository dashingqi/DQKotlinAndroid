package com.dashingqi.module.lambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //匿名函数
//        val result = fun(arg1: Int, arg2: Int): Int {
//            return arg1 + arg2
//        }
//
//        var result1 = test { arg1: Int, arg2: Int -> arg1 + arg2 }
//
//        var result2 = test { arg1, arg2 -> arg1 + arg2 }
//
//        println("result1 ----> $result1, result2 ----> $result2")

//        lambdaTestOne()
//        lambdaTestTwo()
//        lambdaTestThree()
//        testLambdaReturnValue()

//        testFour()

        testAsParameter()
    }


    //具名函数
    fun sum(args1: Int, args2: Int): Int {
        return args1 + args2
    }

    //匿名函数也可以作为参数使用，定义一个传入匿名函数参数的函数
    fun test(action: (Int, Int) -> Int): Int {
        return action(1, 2)
    }

    // action:(Int,Int),它的意思是传入一个Lambda表达式是传入两个int，返回一个int，在这个函数中调用action(1,2)的意思是执行这个lambda表达式，传入的参数是1和2


    //当lambda表达式只有一个参数的时候，你可以在你的代码中将其省略，并用it来代替，这是一个很有用的特性


    /**
     * 这是一个测试lambda表达式的函数
     *  用来测试无参数有返回值的lambda表达式
     */
    private fun lambdaTestOne() {
        { println("this is test one") }()
    }

    /**
     * 这是用来测试lambda表达式 有参数有返回值的函数
     */
    private fun lambdaTestTwo() {
        val sum = { a: Int, b: Int -> a + b }(4, 5)
        println("sum === $sum")
    }

    /**
     * 我们将一个lambda表达式赋值给一个变量
     * 我们通过变量来调用lambda表达式
     */
    private fun lambdaTestThree() {
        val sum = { a: Int, b: Int -> a + b }
        println("totalSum === ${sum(10, 10)}")
    }

    /**
     * 这是测试lambda表达式的返回值类型的
     */
    private fun testLambdaReturnValue() {
        println("=========================")

        val result1 = {
            println("输出语句1"); "字符串"
        }()

        println("返回值：$result1")
        println("返回值类型：${result1.javaClass}")


        println("=========================")

        val result2 = {
            println("输出语句1");
            println("输出语句2");
            18
        }()

        println("返回值 $result2")
        println("返回值类型 ${result2.javaClass}")

        println("=========================")

        val result3 = {
            println("输出语句1")
            println("输出语句2")
            true
        }()

        println("返回值 $result3")
        println("返回值类型 ${result3.javaClass}")

    }

    /**
     * 这是用来练习子啊Lambda表达式的实际返回值后面书写语句
     */
    private fun testFour() {
        val result = { a: Int, b: Int ->
            a + b
            "我是int"
        }(5, 6)

        println("result ---> $result")
    }


    /**
     * 这是用来测试Lambda作为参数的测试
     */
    private fun testAsParameter() {
        //定一个Int数组
        val list = 1..20
        //筛选能被10整除的
        println("==========================")
        //没有使用it关键字之前
        println(list.pickNUm(2) { y: Int -> y % 10 == 0 })
        //使用关键字之后
        println(list.pickNUm(2) { it % 10 == 0 })
    }

    /**
     * function: (Int) -> Boolean
     *
     * function: 形式参数名，可以任意修改
     *
     * (Int) -> Boolean 形式参数类型 这里描述的是一个函数类型，函数的参数是Int类型 函数的返回值是Boolean类型的
     */
    private fun IntRange.pickNUm(need: Int, function: (Int) -> Boolean): List<Int> {

        //声明一个集合
        val resultList = mutableListOf<Int>()

        // this 指向定义的区间范围（IntRange）
        for (i in this) {
            if (function(i)) {
                resultList.add(i)
            }
        }
        return resultList
    }


}
