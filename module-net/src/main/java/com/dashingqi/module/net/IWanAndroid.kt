package com.dashingqi.module.net

import retrofit2.Call
import retrofit2.http.GET

/**
 * @author : zhangqi
 * @time : 12/22/20
 * desc :
 */
interface IWanAndroid {
    @GET("/wxarticle/chapters/json")
    fun getChapters(): Call<BaseResponse>
}