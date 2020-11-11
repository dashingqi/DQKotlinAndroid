package com.chiatai.module_kotlin_appoint.sp

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author : zhangqi
 * @time : 2020/11/11
 * desc : SP的被委托类
 */
class SPDelegate<T>(private val key: String, private val defaultValue: T) :
    ReadWriteProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return SPUtils.getSpValue(key, defaultValue)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        SPUtils.putSpValue(key, value)
    }

}