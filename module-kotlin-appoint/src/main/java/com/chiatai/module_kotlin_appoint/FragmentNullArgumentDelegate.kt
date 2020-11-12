package com.chiatai.module_kotlin_appoint

import android.os.Bundle
import androidx.fragment.app.Fragment
import java.lang.IllegalStateException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @ProjectName: KotlinProject
 * @Package: com.chiatai.module_kotlin_appoint
 * @ClassName: FragmentNullArgumentDelegate
 * @Author: DashingQI
 * @CreateDate: 2020/11/10 11:24 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/10 11:24 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
class FragmentNullArgumentDelegate<T:Any?>:ReadWriteProperty<Fragment,T?> {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        //属性的名字
        var key = property.name
        return thisRef.arguments?.get(key) as? T ?: throw IllegalStateException("error")
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T?) {
        val bundle =  thisRef.arguments ?: Bundle().also(thisRef::setArguments)
        var key = property.name
        value?.let {
            bundle.put(key,it)
        }?:bundle.remove(key)
    }
}