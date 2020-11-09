package com.dashingqi.kotlinproject.属性委托

/**
 *
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.kotlinproject.属性委托
 * @ClassName: DelegatePlayer
 * @Author: DashingQI
 * @CreateDate: 2020/11/9 11:02 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/9 11:02 PM
 * @UpdateRemark:
 * @Version: 1.0
 */

//委托对象
class DelegatePlayer(private val gamerPlayer:IGamePlayer):IGamePlayer by gamerPlayer
