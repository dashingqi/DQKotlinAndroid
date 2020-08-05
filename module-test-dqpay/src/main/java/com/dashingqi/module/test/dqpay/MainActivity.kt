package com.dashingqi.module.test.dqpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dashingqi.dqpay.callback.IPayCallback
import com.dashingqi.dqpay.utils.PayUtils
import com.dashingqi.wxpay.bean.WXPayInfoBean
import com.dashingqi.wxpay.impl.WXPay
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTestAliPay.setOnClickListener {

        }

        btnTestWxPay.setOnClickListener {

            WXPay.initWxPay(this, "wx4e31f025b5569a9c")

            var wxPayInfoBean = WXPayInfoBean()
            wxPayInfoBean.appId = "wx4e31f025b5569a9c"
            wxPayInfoBean.partnerId = "1585891821"
            wxPayInfoBean.nonceStr = "eaXVF2tbHQyl7NgGEfDUCzOLcYWpAZuj"
            wxPayInfoBean.prepayId = "wx051711373909863c8d153a5c1587348800"
            wxPayInfoBean.sign = "1BC632CB1381C9DC0A2E015C113E6356"
            wxPayInfoBean.timeStamp = "1596618697"

            var wxPayCallback = object : IPayCallback<WXPayInfoBean> {
                override fun onCancel() {
                    Log.d("wxPayInfo", "pay onCancel")
                }

                override fun onFail() {
                    Log.d("wxPayInfo", "pay onFail")
                }

                override fun onSuccess(data: WXPayInfoBean) {
                    Log.d("wxPayInfo", "pay onSuccess ----> appId ===>  ${data.appId}")

                }

            }
            PayUtils.pay(WXPay, this, wxPayInfoBean, wxPayCallback)

        }
    }
}
