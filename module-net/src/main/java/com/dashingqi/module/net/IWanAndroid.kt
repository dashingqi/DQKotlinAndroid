package com.dashingqi.module.net

import com.dashingqi.dqhttp.call.BaseCallBack
import com.dashingqi.module.net.body.ZGYDBody
import retrofit2.Call
import retrofit2.http.*

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

    /**
     * 获取到参数
     */
    @Headers("Content-type:application/json;charset=UTF-8")
    @POST("/h5/getMobile")
    fun getZGYDParam(@Body body:ZGYDBody):BaseCallBack<BaseResponse>
}