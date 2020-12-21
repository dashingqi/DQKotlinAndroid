package com.chiatai.module_kotlin_appoint.entrust

import android.util.Log
import kotlin.reflect.KProperty

/**
 * @author : zhangqi
 * @time : 12/12/20
 * desc :
 */
class PriceDelegate {
    private val TAG = "PriceDelegate"

    private var price: String = "0.0"

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        Log.d(TAG, "设置的属性值为 ${price}: ")
        return "¥${price}"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        Log.d(TAG, "这是设置的值 $value")
        price = value
    }
}