package com.dashingqi.module.system.info

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.CellInfo
import android.telephony.PhoneStateListener
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val telephonyService =
            getSystemService(Context.TELEPHONY_SERVICE)
        var subscriptionService = getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE)
        telephonyService?.let {
//            val telephonyManager = it as TelephonyManager
//            // 运营商的ID
//
//            var activeModemCount = telephonyManager.activeModemCount
//
//            var manufacturerCode = telephonyManager.manufacturerCode


//            Log.d(
//                TAG,
//                "simCarrierId = $simCarrierId " +
//                        "cardIdForDefaultEuicc = $cardIdForDefaultEuicc" +
//                        "activeModemCount = $activeModemCount" +
//                        "manufacturerCode = $manufacturerCode"
//            )
        }

        subscriptionService?.let {
            val subscriptionManager = it as SubscriptionManager
            var subscriptionClass = Class.forName(subscriptionManager.javaClass.name)
            var method = subscriptionClass.getMethod("getDefaultDataPhoneId")
            var method1 = subscriptionClass.getMethod("getDefaultDataSubscriptionId")
            var invoke = method.invoke(subscriptionManager)
            var invoke1 = method1.invoke(subscriptionManager)

            invoke?.let {
                val code: Int = it as Int
                Log.d(TAG, "code = $code")
            }

            invoke1?.let {
                val code1 = it as Int
                Log.d(TAG, "code1 = $code1")
            }
        }
    }
}