package com.dashingqi.module.net

import android.content.Context
import android.content.IntentFilter
import android.icu.text.SimpleDateFormat
import android.net.*
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.telephony.TelephonyManager
import android.util.Log
import com.dashingqi.module.net.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private val connectivityManager by lazy {
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}