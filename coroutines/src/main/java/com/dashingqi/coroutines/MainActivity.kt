package com.dashingqi.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.text = "zhangqisdsadasdsadasdasd"
        updateView.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                Log.d(TAG, "onCreate: currentThread == ${Thread.currentThread().name}")
                val tvLayoutParams = tv.layoutParams
                var width = tvLayoutParams.width
                Log.d(TAG, "onCreate: with = ${width}")
                tv.text = "zhangqisdsadasdsadasdasd"
            }
        }
        Thread {}.start()
        thread {

        }
        var newCachedThreadPool = Executors.newCachedThreadPool()
        newCachedThreadPool.execute {

        }



        GlobalScope.launch {

        }

        GlobalScope.launch(Dispatchers.Main) {
            method1()
        }

        GlobalScope.launch(Dispatchers.Main) {
            val str = async { method2() }
            val str2 = async { method3() }
            handleResult(str.await(), str2.await())

        }

        //启动一个协程
        runBlocking {

            launch {

            }

            async { }

        }

        val job = GlobalScope.launch {
        }

        var coroutineScope = CoroutineScope(Dispatchers.Main).launch {
            Log.d(TAG, "onCreate: CoroutineScope ")
        }


    }

    suspend fun test() = coroutineScope {

    }

    private suspend fun method1() {
        withContext(Dispatchers.IO) {

        }
    }

    private suspend fun method2(): String {
        delay(100)
        return "nihao"
    }

    private suspend fun method3(): String {
        delay(100)
        return "zhangqi"
    }

    private fun handleResult(str: String, str2: String) {
        Log.d(TAG, ":str = $str str2 = $str2 ")
    }

}
