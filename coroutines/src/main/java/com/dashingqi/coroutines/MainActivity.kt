package com.dashingqi.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

            async {  }

        }





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
