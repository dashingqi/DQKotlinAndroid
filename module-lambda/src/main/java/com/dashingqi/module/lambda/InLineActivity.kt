package com.dashingqi.module.lambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * 内联函数的使用
 */
class InLineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_line)
        val lock = ReentrantLock()
        // 当执行内联函数 check(lock){{ println("测试执行inline方法") }}这句代码的时候，
        // 编译器会对check进行优化，省去方法名称，避免出栈和入栈，直接执行方法体内容。
        check(lock) { println("测试执行inline方法") }

        checkNoInLine { true }
    }


    /**
     * 当前check方法被inline修饰，当前的check方法就是一个内联函数
     */
    private inline fun <T> check(lock: Lock, function: () -> T): T {
        lock.lock()
        try {
            return function()
        } finally {
            lock.unlock()
        }
    }

    /**
     * 被声明成内联函数，那么参数也会随之内联，如果存在Lambda表达式，Lambda表达式就不是一个函数对象，也就无法当作参数来传递
     * 此时可以使用 noinline修饰符来修饰这个lambda表达式，让它保持原样，是一个函数对象
     */
    private inline fun checkNoInLine(noinline body: (Int) -> Boolean) {
        test(body)
    }

    private fun test(body: (Int) -> Boolean) {
        println("测试执行非内联参数")
    }
}