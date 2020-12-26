package com.chiatai.module_java.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chiatai.module_java.R
import kotlinx.android.synthetic.main.activity_thread.*
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {

    private val TAG = "ThreadActivity"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val threadLocal = ThreadLocal<String>()
        threadLocal.set("8")

        thread {

            Log.d(TAG, "thread1PreGet == ${threadLocal.get()}")
            threadLocal.set("5")
            Log.d(TAG,Thread.currentThread().name)
            var thread1Get = threadLocal.get()
            Log.d(TAG, "thread1Get == $thread1Get")
        }

        thread {
            Log.d(TAG, "thread2PreGet == ${threadLocal.get()}")
            threadLocal.set("6")
            Log.d(TAG,Thread.currentThread().name)
            var thread2Get = threadLocal.get()
            Log.d(TAG, "thread2Get == $thread2Get")
        }

        btnMainThread.setOnClickListener {
            var mainGet = threadLocal.get()
            Log.d(TAG, "mainGet == $mainGet")
        }
    }
}