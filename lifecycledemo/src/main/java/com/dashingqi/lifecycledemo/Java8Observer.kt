package com.dashingqi.lifecycledemo

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * @author : zhangqi
 * @time : 2020/6/21
 * desc :
 */
class Java8Observer : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {

    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d(Companion.TAG, "performOnStart ")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d(Companion.TAG, "performOnStop ")
    }

    companion object {
        const val TAG = "Java8Observer"
    }
}