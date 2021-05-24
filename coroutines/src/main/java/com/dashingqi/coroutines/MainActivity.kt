package com.dashingqi.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

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


    }

    private suspend fun method1() {
        withContext(Dispatchers.IO) {

        }
    }
}
