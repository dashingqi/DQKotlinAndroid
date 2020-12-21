package com.dashingqi.module.net

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.*
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
        newOkHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d(TAG, "onFailure")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d(TAG, "onResponse ");
            }
        })
    }
}