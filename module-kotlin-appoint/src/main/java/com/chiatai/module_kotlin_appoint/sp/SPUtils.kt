package com.chiatai.module_kotlin_appoint.sp

import android.content.Context
import com.chiatai.module_kotlin_appoint.AppointApp
import java.lang.IllegalStateException

/**
 * @author : zhangqi
 * @time : 2020/11/11
 * desc :
 */
object SPUtils {

    private val spInstance by lazy {
        AppointApp.getInstance().getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    fun <T> putSpValue(name: String, value: T) {

        with(spInstance.edit()) {
            when (value) {
                is String -> putString(name, value)
                is Int -> putInt(name, value)
                is Float -> putFloat(name, value)
                is Long -> putLong(name, value)
                is Boolean -> putBoolean(name, value)
                else -> throw IllegalStateException("$value 不支持的类型")
            }.apply()
        }

    }

    fun <T> getSpValue(name: String, defaultValue: T): T {
        return with(spInstance) {
            var realValue =
                when (defaultValue) {
                    is String -> getString(name, defaultValue)
                    is Int -> getInt(name, defaultValue)
                    is Float -> getFloat(name, defaultValue)
                    is Long -> getLong(name, defaultValue)
                    is Boolean -> getBoolean(name, defaultValue)
                    else -> throw IllegalStateException("$defaultValue 不支持的类型")
                }

            realValue as T
        }
    }
}