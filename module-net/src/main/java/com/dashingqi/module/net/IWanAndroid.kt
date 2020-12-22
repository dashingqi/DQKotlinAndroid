package com.dashingqi.module.net

import com.dashingqi.dqhttp.call.BaseCallBack
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

    @GET("/wxarticle/chapters/json")
    fun getChapters1(): BaseCallBack<BaseResponse>
}