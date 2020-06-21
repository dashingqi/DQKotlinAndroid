package com.dashingqi.lifecycledemo

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author : zhangqi
 * @time : 2020/6/21
 * desc :
 */
class MyObserverDemo(var lifecycle: Lifecycle) : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun performOnStart() {
        Log.d(Companion.TAG, "performOnStart ")
        Log.d(TAG, "currentState ---> ${lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun performOnStop() {
        Log.d(Companion.TAG, "performOnStop ")
        Log.d(TAG, "currentState ---> ${lifecycle.currentState}")
    }

    companion object {
        private const val TAG = "MyObserverDemo"
    }

}