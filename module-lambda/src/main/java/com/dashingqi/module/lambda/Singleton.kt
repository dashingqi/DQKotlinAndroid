package com.dashingqi.module.lambda

/**
 * @author : zhangqi
 * @time : 2020/8/7
 * desc : 实现单例
 */
class Singleton private constructor() {
    private object Holder {
        val instance = Singleton()
    }

    companion object {
        val instance by lazy {
            Holder.instance
        }
    }
}


//使用 object 关键字
object Singletons {

}