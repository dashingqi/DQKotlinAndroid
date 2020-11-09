package com.dashingqi.kotlinproject.属性委托

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.kotlinproject.属性委托
 * @ClassName: Delegate1
 * @Author: DashingQI
 * @CreateDate: 2020/11/9 11:23 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/9 11:23 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
class Delegate1:ReadWriteProperty<Any,String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "dashignqi delegate1"
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println(value)
    }
}