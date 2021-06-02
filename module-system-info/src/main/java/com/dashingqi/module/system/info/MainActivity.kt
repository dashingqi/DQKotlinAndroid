package com.dashingqi.module.system.info

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.telephony.*
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
            val telephonyManager = it as TelephonyManager
            val listener = object : PhoneStateListener() {
                override fun onDataConnectionStateChanged(state: Int, networkType: Int) {
                    super.onDataConnectionStateChanged(state, networkType)
                    Log.d(TAG, "onDataConnectionStateChanged: ")
                }
            }

            telephonyManager.listen(listener, PhoneStateListener.LISTEN_DATA_CONNECTION_STATE)
        }

        subscriptionService?.let {
            val subscriptionManager = it as SubscriptionManager
            var accessibleSubscriptionInfoList = subscriptionManager.accessibleSubscriptionInfoList
            Log.d(TAG, "onCreate: size =${accessibleSubscriptionInfoList?.size} ")
            var subscriptionClass = Class.forName(subscriptionManager.javaClass.name)
            var method = subscriptionClass.getMethod("getDefaultDataPhoneId")
            var method1 = subscriptionClass.getMethod("getDefaultDataSubscriptionId")
            var method2 = subscriptionClass.getMethod("getActiveDataSubscriptionId")

            var invoke = method.invoke(subscriptionManager)
            var invoke1 = method1.invoke(subscriptionManager)
            var invoke2 = method2.invoke(subscriptionManager)


            invoke?.let {
                val code: Int = it as Int
                Log.d(TAG, "code = $code")
            }

            invoke1?.let {
                val code1 = it as Int
                Log.d(TAG, "code1 = $code1")
            }

            invoke2?.let {
                val code2 = it as Int
                Log.d(TAG, "code2 = $code2")
            }

        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            /** 获取到ConnectivityManager对象 */
            val mConnectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            Log.d(TAG, "perform ---->")
            mConnectivityManager?.let {
                var builder =
                    NetworkRequest.Builder()
                Telephony
                var request = builder.build()
//                it.registerNetworkCallback(request, object : ConnectivityManager.NetworkCallback() {
//                    override fun onAvailable(network: Network) {
//                        super.onAvailable(network)
//                        Log.d(TAG, "onAvailable: ")
//                    }
//
//                    override fun onLosing(network: Network, maxMsToLive: Int) {
//                        super.onLosing(network, maxMsToLive)
//                        Log.d(TAG, "onLosing: ")
//                    }
//
//                    override fun onLost(network: Network) {
//                        super.onLost(network)
//                        Log.d(TAG, "onLost: ")
//                    }
//                })
            }
        }
    }
}