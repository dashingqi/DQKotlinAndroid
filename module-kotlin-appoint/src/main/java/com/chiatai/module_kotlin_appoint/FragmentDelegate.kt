package com.chiatai.module_kotlin_appoint

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author : zhangqi
 * @time : 2020/11/10
 * desc :
 */
class FragmentDelegate<T : Any> : ReadWriteProperty<Fragment, Any> {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): Any {
        //拿到对应的key
        var key = property.name
        return thisRef.arguments?.get(key) as? T ?: ""
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: Any) {
        var key = property.name
        val bundle = thisRef.arguments ?: Bundle().also(thisRef::setArguments)
        bundle.put(key, value)
    }
}