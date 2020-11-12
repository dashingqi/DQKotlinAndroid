package com.chiatai.module_kotlin_appoint

import android.app.Application
import android.content.Context

/**
 * @author : zhangqi
 * @time : 2020/11/11
 * desc :
 */
class AppointApp : Application() {


    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }

    companion object {

        var mInstance: Context? = null
        fun getInstance() = mInstance!!
    }
}