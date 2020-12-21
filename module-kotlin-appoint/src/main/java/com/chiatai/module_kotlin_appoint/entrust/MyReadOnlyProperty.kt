package com.chiatai.module_kotlin_appoint.entrust

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * @author : zhangqi
 * @time : 12/12/20
 * desc :
 */
class MyReadOnlyProperty:ReadOnlyProperty<Any,String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
       return ""
    }
}