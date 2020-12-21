package com.chiatai.module_kotlin_appoint.entrust

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author : zhangqi
 * @time : 12/12/20
 * desc :
 */
class MyReadWriteProperty:ReadWriteProperty<Any,String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return ""
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {

    }
}