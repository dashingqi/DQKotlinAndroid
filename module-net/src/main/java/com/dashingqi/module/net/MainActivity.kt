package com.dashingqi.module.net

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dashingqi.module.net.body.ZGYDBody
import com.dashingqi.module.net.utils.Utils

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // 创建一个OkHttpClient对象
//        var newOkHttpClient = OkHttpClient.Builder()
//                .connectTimeout(2000, TimeUnit.MILLISECONDS)
//                .build()
//
//        //创建一个request对象
//        val request = Request.Builder()
//                .addHeader("device", "android")
//                //这个是鸿洋大神 WanAndroid 中提供的api
//                .url("https://wanandroid.com/wxarticle/chapters/json")
//                .build()
//
//        //val call =  newOkHttpClient.newCall(request) //创建了一个可执行的call对象
//        // call.enqueue方法进行 异步请求
//        newOkHttpClient.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                Log.d(TAG, "onFailure thread = ${Thread.currentThread().name}")
//
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                Log.d(TAG, "onResponse thread = ${Thread.currentThread().name}")
//                runOnUiThread {
//                    Log.d(TAG, "thread name = ${Thread.currentThread().name}")
//                }
//
//            }
//        })


        //发起网络请求，请求
//        Service.netService.create(IWanAndroid::class.java).getChapters()
//            .enqueue(object : Callback<BaseResponse> {
//                override fun onResponse(
//                    call: Call<BaseResponse>,
//                    response: Response<BaseResponse>
//                ) {
//                    Log.d(TAG, "onResponse ")
//                }
//
//                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
//                    Log.d(TAG, "onFailure")
//                }
//
//            })
//
//        Service.netService.create(IWanAndroid::class.java).getChapters1()
//            .doOnResponseSuccess { call, response ->
//                Toast.makeText(this, "请求成了", Toast.LENGTH_LONG).show()
//            }
//            .doOnFailure {
//                Toast.makeText(this, "失败了", Toast.LENGTH_LONG).show()
//            }

        var traceId = "mfawsxtcmyplwzpayzzvdvbsowxmkynr"
        var msgId = "redbyxsdetddwaaffajcwwapspykftzx"
        var appId = "300012039171"
        var businessType = "3"
        var timestamp = Utils.dateToStamp()
        var version = "1.0"
        var appKey = "2B633445E2A828EA40D109B58E5076A0"

        /**
         *  MD5(appId +
        businessType + msgId + timestamp + traceId
        + version+appkey)
         *
         *
         */
        var md5Origin = "$appId$businessType$msgId$timestamp$traceId$version$appKey"
        var md5Value = Utils.md5(md5Origin)
        Log.d("tag == ", md5Value)
        Log.d("tag == time","$timestamp")

        var zgydBody = ZGYDBody(
                version, "$timestamp",
                appId, businessType, traceId, md5Value,
                msgId)

        Service.ZGYDService.create(IWanAndroid::class.java).getZGYDParam(zgydBody)
                .doOnResponseHeaderSuccess { call, response ->
                    Log.d(TAG,"resultCode == ${response.body.resultCode} " +
                            "resultDesc = ${response.body.resultDesc} token == ${response.body.token}")

                }


    }
}