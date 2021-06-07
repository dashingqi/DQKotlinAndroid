package com.dashingqi.coroutines

import android.util.Log
import kotlinx.coroutines.*

/**
 * @author zhangqi61
 * @since 6/7/21
 */
private const val TAG = "CoroutinesDemo"

fun main() {
    GlobalScope.launch(Dispatchers.Main) {
        Log.d(TAG, "main: thread-name = ${Thread.currentThread().name} ")
        method1()
        Log.d(TAG, "main: thread-name 1 = ${Thread.currentThread().name}")

    }
}

suspend fun method1() {
    withContext(Dispatchers.IO) {
        delay(5000)
        Log.d(TAG, "method1: ")
    }
}