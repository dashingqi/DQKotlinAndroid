package com.dashingqi.module.net.body

/**
 * @author zhangqi61
 * @since 2021/4/13
 */
class ZGYDBody(
    var version: String="1.0", var timestamp: String = "${System.currentTimeMillis()}", var appId: String,
   var  businessType: String, var traceid: String, var sign: String,var  msgId: String
)