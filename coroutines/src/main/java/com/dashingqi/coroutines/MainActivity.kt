package com.dashingqi.coroutines

import android.content.Intent
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : ScopeActivity() {
    private val TAG = "MainActivity"


    val mainScope = MainScope()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jump.setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                startActivity(this)
            }
        }


        GlobalScope.launch(Dispatchers.Main) {
            async(Dispatchers.IO){}
            testLaunch()
        }
        Log.d(TAG, "testLaunch: ")
    }

    private fun test(flag: Int) {

        updateView.setOnClickListener {

        }
    }

    /**
     * 测试launch函数
     */
    private suspend fun testLaunch() {
        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.d(TAG, "${Thread.currentThread().name}: -----> 启动协程")

            //该launch函数会继承父协程的上下文
            launch {
                Log.d(TAG, "${Thread.currentThread().name}: ------> 开启一个子协程1")
            }

            Log.d(TAG, ": ${Thread.currentThread().name} ----> 创建懒加载子协程")
            val job1 = launch(start = CoroutineStart.LAZY, context = Dispatchers.IO) {
                Log.d(TAG, "${Thread.currentThread().name}: --------> 开启一个懒加载协程1");
            }

            val job2 = launch(start = CoroutineStart.LAZY) {
                Log.d(TAG, "${Thread.currentThread().name}: ---------> 开启一个懒加载协程2")
            }

            Log.d(TAG, ": 显示启动懒加载子子协程1")
            job1.start()

            Log.d(TAG, "隐式启动懒加载子协程2: ")
            job2.join()
            delay(5000)

        }

        job.join()

    }

    suspend fun method1() {
        withContext(Dispatchers.IO) {}

    }

}
