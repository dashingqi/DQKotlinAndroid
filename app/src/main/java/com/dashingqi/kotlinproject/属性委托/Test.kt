package com.dashingqi.kotlinproject.属性委托

/**
 *
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.kotlinproject.属性委托
 * @ClassName: Test
 * @Author: DashingQI
 * @CreateDate: 2020/11/9 11:21 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/9 11:21 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
class Test {
    var str:String by Delegate()

    var str1 :String by Delegate1()
}