package com.dashingqi.kotlinproject.属性委托

import kotlin.properties.Delegates

/**
 *
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.kotlinproject.属性委托
 * @ClassName: LearnTrust
 * @Author: DashingQI
 * @CreateDate: 2020/11/9 10:59 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/9 10:59 PM
 * @UpdateRemark:
 * @Version: 1.0
 */

// Delegates.observable 可以用来观察一个属性变化的过程
// 可以将属性委托给 Delegates.observable 来观察属性的变化过程
var observableProp:String by Delegates.observable("dashingqi"){
    property, oldValue, newValue ->
    println("newValue === > $newValue")
}

// Delegates.vetoable同样是用来观察属性的变化过程
//不过vetoable可以通过处理器函数决定属性值是否生效
var vetobalProp:Int by Delegates.vetoable(5){
    property, oldValue, newValue ->
    newValue>oldValue
}

fun main(){
    var realGamePlayer = RealGamePlayer("dashingqi")
    val delegatePlayer = DelegatePlayer(realGamePlayer)
    delegatePlayer.play()
    delegatePlayer.upgrade()

    val test = Test()
    test.str = "dashingqi"

    println("str1 = ${test.str1}")
    test.str1 = "zhangqi"

    observableProp = "zhangqi"
    observableProp = "yhn"

    println("vetobalProp == $vetobalProp")
    vetobalProp  = 10
    println("vetobalProp == $vetobalProp")
    vetobalProp = 4
    println("vetobalProp == $vetobalProp")
    vetobalProp = 20
    println("vetobalProp == $vetobalProp")

    val user = User(mapOf("name" to "dashingqi","age" to 123))
    println("name = ${user.name}")
    println("age = ${user.age}")
}

//在一个映射中存储属性值
class User(private val map:Map<String,Any?>){
    val name:String by map
    val age:Int by map
}


