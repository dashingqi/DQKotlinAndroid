package com.dashingqi.module.net.body

/**
 * @author zhangqi61
 * @since 2021/4/13
 */
class ZGYDBody(
    version: String="1.0", timestamp: String = "${System.currentTimeMillis()}", appId: String,
    businessType: String, traceid: String, sing: String, msgId: String, expandParams: String
)