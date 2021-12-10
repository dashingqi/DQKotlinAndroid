package com.dashingqi.coroutines

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author zhangqi61
 * @since 2021/12/10
 */
private const val TAG = "ChannelMain"
suspend fun main() {
    // 创建一个Channel
    val channel = Channel<Int>()

    // 创建一个生产者
    val product = GlobalScope.launch {
        var i = 0
        while (true) {
            channel.send(i++)
            // 每隔1秒发送
            delay(1000)
        }

    }

    // 创建一个消费者
    val consumer = GlobalScope.launch {
        while (true) {
            val element = channel.receive()
            Log.d(TAG, "element is $element")
        }

    }

    product.join()
    consumer.join()
}