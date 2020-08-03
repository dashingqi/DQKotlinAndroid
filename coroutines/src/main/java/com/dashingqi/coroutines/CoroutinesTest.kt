package com.dashingqi.coroutines

import kotlinx.coroutines.*

/**
 * @author : zhangqi
 * @time : 2020/4/8
 * desc :
 */

fun main() {

    //useGlobalScope()
    //useRunBlocking()
    //createMoreCoroutines()
    //createMoreAndMoreCoroutines()
    //让程序延迟一段时间在结束 让主线程阻塞一会在结束执行
    //该方法的执行会阻塞当前的线程，并且会阻塞当前线程下的所有协程
    //Thread.sleep(1000)

    //test()
    //useAsync()
    //useTwoAsync()
    //useTwoAsync2()
    useWithContext()
}

/**
 * 开启一个协程的练习
 */
fun useGlobalScope() {

    //该函数可以创建一个协程的作用域
    //传递给launch函数代码块就是在协程中运行了
    //该函数每次创建的都是一个顶层协程，这种协程在程序运行完毕的时候也会跟着一起结束。
    //当执行下面代码的时候，你会发现没有log打印，是因为代码块中的代码还没有及时运行，应用程序就结束了。
    GlobalScope.launch {
        println("codes run in coroutine scope")
        // delay函数可以让当前协程延迟指定时间后在运行
        // delay函数是一个非阻塞式的挂起函数，它只会挂起当前的协程，并不会影响到其他的协程
        delay(1500)
        // 正常在delay(1500)函数执行后，下面的日志信息没有打印出来
        println("codes run in coroutine scope finished")
    }
}

fun useRunBlocking() {
    // runBlocking 函数同样会创建一个协程的作用域
    //可以保证在协程作用域内的所有代码和子协程运行完毕之后，应用程序在结束（作用域内的所有代码和子协程在之前完之前会一直阻塞当前线程的）
    //该函数通常应该在测试环境中使用，正式环境中使用会有性能上的问题
    runBlocking {
        println("codes run in coroutine scope")
        // delay函数可以让当前协程延迟指定时间后在运行。
        delay(1500)
        println("codes run in coroutine scope finished")
    }
}

//创建多个协程 使用launch函数
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

fun createMoreAndMoreCoroutines() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(100000) {
            launch {
                println(".")
            }
        }
    }
    val end = System.currentTimeMillis()

    println("cost time ---> ${end - start}")
}

suspend fun useSuspend() {
//    println("use suspend")
//    //挂起函数之间是可以互相调用
//    delay(1000)
    // 挂起函数是没有协程作用域的，此时是调用不了 launch函数的会失败的，因为launch函数需要在具有协程作用域中才能被调用
    // launch{}
}

suspend fun useSuspendWithCoroutinesScope() = coroutineScope {
    launch {
        print("useSuspendWithCoroutinesScope")
        delay(1000)
    }
}

fun test() {
    runBlocking {
        launch {
            // launch业务逻辑越来越复杂，抽取一个函数出去
            //抽取的函数使用suspend关键字来修饰，表示是挂起函数
            //挂起函数之间可以互相调用，但是不具有协程作用域的
            // 使用coroutineScope函数 可以解决这个问题，它是一个挂起函数，并且会继承外部的协程作用域并创建一个子作用域的
            useSuspendWithCoroutinesScope()

        }
    }
}

fun useAsync() {
    runBlocking {
        launch {
            var result = async {
                4 * 4
            }.await()

            println("result ----> $result")
        }
    }
}

/**
 * 当调用await()方法时，如果代码中的代码还没执行完毕，那么await方法会把当前协程阻塞住，直到获取到async函数的执行结果
 */
fun useTwoAsync() {
    runBlocking {
        launch {
            var start = System.currentTimeMillis()
            var result1 = async {
                delay(1000)
                5 + 5
            }.await()

            var result2 = async {
                delay(1000)
                4 + 4
            }.await()

            println("result -> ${result1 + result2}")

            var end = System.currentTimeMillis()
            println("cots time ---> ${end - start}")
        }
    }
    // 函数运行结果时 2045毫秒， 在子作用域中执行了挂起函数 delay()阻塞了当前的子协程，await()没有方法没有获取到结果，就会阻塞当前的协程
}

fun useTwoAsync2() {
    runBlocking {
        launch {
            var start = System.currentTimeMillis()
            var result1 = async {
                delay(1000)
                4 + 4
            }

            var result2 = async {
                delay(1000)
                5 + 5
            }

            // 让两个 async函数并行
            println("result ----> ${result1.await() + result2.await()}")
            var end = System.currentTimeMillis()
            println("cost time ----> ${end - start}")
        }
    }
}

fun useWithContext() {
    runBlocking {
        launch {
            var result = withContext(Dispatchers.Default) {
                5 + 5
            }

            println("result ---> $result")
        }
    }
}