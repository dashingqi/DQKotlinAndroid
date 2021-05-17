package com.dashingqi.module.provider

import android.app.Application
import android.util.Log

/**
 * @author : zhangqi
 * @time : 5/18/21
 * desc :
 */
class ProviderApplication:Application() {
    private  val TAG = "ProviderApplication"
    override fun onCreate() {
        Log.d(TAG, ": onCreate");
        super.onCreate()
    }
}