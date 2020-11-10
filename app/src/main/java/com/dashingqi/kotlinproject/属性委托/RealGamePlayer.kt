package com.dashingqi.kotlinproject.属性委托

/**
 *
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.kotlinproject.属性委托
 * @ClassName: RealGamePlayer
 * @Author: DashingQI
 * @CreateDate: 2020/11/9 11:00 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/9 11:00 PM
 * @UpdateRemark:
 * @Version: 1.0
 */

//被委托对象
class RealGamePlayer(private val gamerName:String):IGamePlayer {
    override fun play() {
            println("$gamerName playing game")
    }

    override fun upgrade() {
        println("$gamerName upgrade in game")
    }
}