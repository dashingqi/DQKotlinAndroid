package com.dashingqi.kotlinproject.属性委托

import kotlin.reflect.KProperty

/**
 *
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.kotlinproject.属性委托
 * @ClassName: Delegate
 * @Author: DashingQI
 * @CreateDate: 2020/11/9 11:11 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/9 11:11 PM
 * @UpdateRemark:
 * @Version: 1.0
 *
 * 被代理类
 * 属性委托 是把属性的set和get 委托给 被委托类中的 getValue()和setValue()
 * 针对是val的属性 需要被委托类中提供getValue()
 * 针对是var的属性，需要被委托类中提供 getValue()和setValue()
 */
class Delegate {

    operator fun setValue(thisRef:Any?,property:KProperty<*>,value:String){
        println("$value has been assigned to ${property.name} in $thisRef")
    }

    operator fun getValue(thisRef:Any?,property:KProperty<*>):String{
       return "$thisRef thank you for delegate,${property.name} for me"
    }
}