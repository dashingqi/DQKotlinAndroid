package com.dashingqi.module.kotlin.base

/**
 * @author : zhangqi
 * @time : 12/14/20
 * desc :
 */
class Generic<T : String> {

    var t: T? = null

    fun setData(data: T) {
        t = data
    }
}