package com.dashingqi.module.net

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dashingqi.module.net.body.ZGYDBody
import com.dashingqi.module.net.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        Log.d("tag == time", "$timestamp")

        var zgydBody = ZGYDBody(
                version, "$timestamp",
                appId, businessType, traceId, md5Value,
                msgId)

        btnToken.setOnClickListener {
            Service.ZGYDService.create(IWanAndroid::class.java).getZGYDParam(zgydBody)
                    .doOnResponseHeaderSuccess { call, response ->

                        tokenInfo.text = "resultCode == ${response.body.resultCode} \n " +
                                "resultDesc = ${response.body.resultDesc} \n " +
                                "token == ${response.body.token}"

                        Log.d(TAG, "resultCode == ${response.body.resultCode} " +
                                "resultDesc = ${response.body.resultDesc} token == ${response.body.token}")

                    }
        }


    }
}