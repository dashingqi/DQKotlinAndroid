package com.dashingqi.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author : zhangqi
 * @time : 2020/4/8
 * desc :
 */

fun main() {
    //该函数可以创建一个协程的作用域
    //传递给launch函数代码块就是在协程中运行了

    //该函数每次创建的都是一个顶层协程，这种协程在程序运行完毕的时候也会跟着一起结束。
    //当执行下面代码的时候，你会发现没有log打印，是因为代码块中的代码还没有及时运行，应用程序就结束了。
//    GlobalScope.launch {
//        println("codes run in coroutine scope")
//        // delay函数可以让当前协程延迟指定时间后在运行。
//        delay(1500)
//        println("codes run in coroutine scope finished")
//    }


    //useRunBlocking()

    createMoreCoroutines()
    //让程序延迟一段时间在结束 让主线程阻塞一会在结束执行
    Thread.sleep(1000)
}

fun useRunBlocking() {
    // runBlocking 函数同样会创建一个协程的作用域
    //可以保证在协程作用域内的所有代码和子协程
    //该函数通常应该在测试环境中使用，正式环境中使用会有性能上的问题
    runBlocking {
        println("codes run in coroutine scope")
        // delay函数可以让当前协程延迟指定时间后在运行。
        delay(1500)
        println("codes run in coroutine scope finished")
    }
}

//创建多个协程 使用launch
// runBlocking函数只是创建协程的作用域 协程中运行的代码是 launch函数中传递的代码块
// runBlocking函数解决的是，GlobalScope.launch会在程序运行结束后强制结束协程，而runBlocking函数创建的作用域不会这样，
fun createMoreCoroutines() {
    runBlocking {
        launch {
            println("launch1")
            delay(1000)
            println("launch1 finished")

        }
        launch {

            println("launch2")
            delay(1000)
            println("launch2 finished")

        }
    }
}