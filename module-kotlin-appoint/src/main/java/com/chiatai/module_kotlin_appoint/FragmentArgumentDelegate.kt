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
 * @ClassName: FragmentArgumentDelegate
 * @Author: DashingQI
 * @CreateDate: 2020/11/10 11:09 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/10 11:09 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
class FragmentArgumentDelegate<T:Any>:ReadWriteProperty<Fragment,T> {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        //属性的名字
        var key = property.name
        // as? :如果属性不是目标类型的就会出现ClassCastException
        // 安全类型转换，如果转换不成功就返回null
        return thisRef.arguments?.get(key) as? T ?: throw IllegalStateException("error")
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
        val bundle =  thisRef.arguments ?: Bundle().also(thisRef::setArguments)
        var key = property.name
        bundle.put(key,value)
    }
}