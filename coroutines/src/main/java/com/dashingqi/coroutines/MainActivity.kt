package com.dashingqi.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

class MainActivity : ScopeActivity() {
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

        jump.setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                startActivity(this)
            }
        }
//        GlobalScope.launch(Dispatchers.Main) {
//            val str = async { method2() }
//            val str2 = async { method3() }
//            handleResult(str.await(), str2.await())
//        }

        GlobalScope.launch(Dispatchers.Main) {

            Log.d(TAG, "thread-name = ${Thread.currentThread().name} ")
            launch(Dispatchers.IO) {
                delay(5000)
                Log.d(TAG, "launch: thread-name = ${Thread.currentThread().name}")
            }

            Log.d(TAG, "onCreate: thread-name = ${Thread.currentThread().name}")
        }
        Log.d(TAG, "onCreate: ")
    }

    private suspend fun method1() {
        withContext(Dispatchers.IO) {
            delay(5000)
            Log.d(TAG, "method1: thread-name = ${Thread.currentThread().name}")
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
