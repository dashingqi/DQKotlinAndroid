package com.chiatai.module_java

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chiatai.module_java.proxy.IProxy
import com.chiatai.module_java.proxy.ProxyUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var proxy = ProxyUtils.getProxy(IProxy::class.java)
        proxy.method1()
        proxy.method2()
    }
}