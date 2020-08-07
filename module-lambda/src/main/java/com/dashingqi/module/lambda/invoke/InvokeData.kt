package com.dashingqi.module.lambda.invoke

/**
 * @author : zhangqi
 * @time : 2020/8/7
 * desc :
 */
data class InvokeData(var name: String) {

    operator fun invoke() {
        println("name ----> $name")
    }
}