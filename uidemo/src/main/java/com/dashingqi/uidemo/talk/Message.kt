package com.dashingqi.uidemo.talk

/**
 * @author : zhangqi
 * @time : 2020/5/2
 * desc :
 */
data class Message(var content: String, var type: Int) {
    companion object {
        const val TYPE_RECEIVE = 0
        const val TYPE_SEND = 1
    }
}