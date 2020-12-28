package com.dashingqi.module.life

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

/**
 * @author : zhangqi
 * @time : 12/27/20
 * desc :
 */
class LifeApplication : Application() {

    private val TAG = "LifeApplication"

    private val mActivityLifecycleCallbacks by lazy {
        MyActivityLifecycleCallbacks(
            onActivityCreatedAction = { activit, bundle ->
                Log.e(TAG, "onCreate: ")


            },
            onActivityStoppedAction = { activity ->

                Log.e(TAG, "onStop ")

            },
            onActivityDestroyedAction = { activity ->
                Log.e(TAG, "onDestroy")

            })
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
    }

    /**
     * 用于判断当前进程是否处于前台
     */
    fun isForegroundMethod(): Boolean = mActivityLifecycleCallbacks.getCount() > 0


    companion object{
        private  var  instance :LifeApplication?= null
        fun getInstance () = instance!!
    }

    /**
     * 2020-12-27 13:23:08.142 20454-20454/com.dashingqi.module.life E/LifeApplication: onCreate:
    2020-12-27 13:23:08.243 20454-20454/com.dashingqi.module.life E/MainActivity: top application is com.dashingqi.module.life
    2020-12-27 13:23:08.247 20454-20454/com.dashingqi.module.life E/MainActivity: appIsForeground == true
    2020-12-27 13:23:08.248 20454-20454/com.dashingqi.module.life E/MainActivity: foregroundApp is com.dashingqi.module.life
    2020-12-27 13:23:18.824 20454-20454/com.dashingqi.module.life E/LifeApplication: onStop
    2020-12-27 13:23:18.830 20454-20454/com.dashingqi.module.life E/LifeApplication: onDestroy
     */
}
