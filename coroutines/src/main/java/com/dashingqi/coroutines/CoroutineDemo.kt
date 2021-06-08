package com.dashingqi.coroutines

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * @author : zhangqi
 * @time : 6/8/21
 * desc :
 */
private const val TAG = "CoroutineDemo"
suspend fun main() {
    GlobalScope.launch(Dispatchers.Main) {
        Log.d(TAG, ":thread-name = ${Thread.currentThread().name} ");

    }
}

