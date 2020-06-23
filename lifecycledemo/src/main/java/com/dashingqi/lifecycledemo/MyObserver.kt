package com.dashingqi.lifecycledemo

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author : zhangqi
 * @time : 2020/4/5
 * desc :
 */
class MyObserver(val lifecycle: Lifecycle) : LifecycleObserver {
    private val TAG = "MyObserver"
    val myLifecycle = lifecycle


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun activityCreate() {
        Log.d(TAG, "activityCreate ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart() {
        Log.d(TAG, "activityStart: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityOnStop() {
        Log.d(TAG, "activityOnStop: ")
    }

    fun state() = myLifecycle.currentState
}