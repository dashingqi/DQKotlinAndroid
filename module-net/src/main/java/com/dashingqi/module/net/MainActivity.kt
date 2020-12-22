package com.dashingqi.module.net

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.time.Duration

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建一个OkHttpClient对象
        var newOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(2000, TimeUnit.MILLISECONDS)
            .build()

        //创建一个request对象
        val request = Request.Builder()
            .addHeader("device", "android")
            //这个是鸿洋大神 WanAndroid 中提供的api
            .url("https://wanandroid.com/wxarticle/chapters/json")
            .build()

        // newOkHttpClient.newCall(request) 创建了一个可执行的call对象
        // call.enqueue方法进行 异步请求
//        newOkHttpClient.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                Log.d(TAG, "onFailure")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                Log.d(TAG, "onResponse ");
//            }
//        })

        //发起网络请求，请求
        Service.netService.create(IWanAndroid::class.java).getChapters()
            .enqueue(object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) {
                    Log.d(TAG, "onResponse ")
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure")
                }

            })

        Service.netService.create(IWanAndroid::class.java).getChapters1()
            .doOnResponseSuccess { call, response ->
                Toast.makeText(this, "请求成了", Toast.LENGTH_LONG).show()
            }
            .doOnFailure {
                Toast.makeText(this, "失败了", Toast.LENGTH_LONG).show()
            }

    }
}