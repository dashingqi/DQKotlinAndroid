package com.dashingqi.module.life

import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTopApplication()

        var appForeground = isAppForeground()
        Log.e(TAG, "appIsForeground == $appForeground")
        var foregroundApp = getForegroundApp()
        Log.e(TAG, "foregroundApp is $foregroundApp")
    }

    override fun onResume() {
        super.onResume()
        LifeApplication.getInstance()?.let {
            Log.e(TAG, "isForeground = ${it.isForegroundMethod()}")
        }
    }

    private fun getTopApplication() {

        //首先获取到ActivityManager
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        if (activityManager.getRunningTasks(1) == null) {
            Log.e(TAG, "getForegroundActivity: ")
            return
        }

        var runningTaskInfo = activityManager.getRunningTasks(1)[0]
        if (runningTaskInfo == null) {
            Log.e(TAG, "runningTaskInfo is null")
            return
        }

        runningTaskInfo.topActivity?.let {
            Log.e(TAG, "top application is ${it.packageName}")
        }

        // 2020-12-27 12:30:12.302 16838-16838/com.dashingqi.module.life E/MainActivity: top application is com.dashingqi.module.life
    }

    /**
     * 判断当前应用是否处于前台
     */
    private fun isAppForeground(): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        /**
         * 存活的App进程
         */
        var runningAppProcesses = activityManager.runningAppProcesses

        if (runningAppProcesses == null) {
            Log.e(TAG, "runningAppProcesses is null")
            return false
        }

        runningAppProcesses.forEach {
            if (it.processName == packageName && (it.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND)) {
                return true
            }
        }
        return false
    }

    /**
     * 用于判断那个应用是处于前台的
     */
    private fun getForegroundApp(): String? {

        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        var runningAppProcesses = activityManager.runningAppProcesses
        if (runningAppProcesses.isNullOrEmpty()) {
            return null
        }

        runningAppProcesses.forEach {

            if (it.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND || it.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE) {
                return it.processName
            }
        }

        return null
    }
}