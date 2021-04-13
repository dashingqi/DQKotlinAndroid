package com.dashingqi.module.net.response

import com.dashingqi.module.net.BaseResponse

/**
 * @author : zhangqi
 * @time : 4/13/21
 * desc :
 */
data class ZGYDResponse(var body: BodyData) : BaseResponse()

data class BodyData(var resultCode: String, var resultDesc: String, var token: String = "")