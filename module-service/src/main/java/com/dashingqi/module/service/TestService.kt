package com.dashingqi.module.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

/**
 * @author : zhangqi
 * @time : 12/31/20
 * desc :
 */
class TestService : Service() {
    private val TAG = "TestService"

    val myBinder = MyBinder()

    override fun onCreate() {
        Log.d(TAG, ": onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommend: ")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnBind: ")
        return super.onUnbind(intent)
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "onBind")
        return MyBinder()
    }


    class MyBinder : Binder() {

    }
}