package com.chiatai.module_java

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.chiatai.module_java.proxy.IProxy
import com.chiatai.module_java.proxy.ProxyUtils
import com.chiatai.module_java.thread.ThreadActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnThread.setOnClickListener {
            Intent(this, ThreadActivity::class.java).apply {
                startActivity(this)
            }
        }

        var proxy = ProxyUtils.getProxy(IProxy::class.java)
        var proxyClass = proxy.javaClass
        var method1 = proxyClass.getMethod("method1")
        var annotations = method1.annotations
        Log.d(TAG, "size -- > ${annotations.size}")
        annotations.forEach {
            Log.d(TAG, it.annotationClass.simpleName!!)
        }

        var myAnnotationClass = Class.forName("com.chiatai.module_java.annotation.MyAnnotation")
        var method =
            myAnnotationClass.getMethod("getAnnotation", String::class.java, String::class.java)
        var annotations1 = method.annotations
        Log.d(TAG, "size --> ${annotations1.size}")
        var genericParameterTypes = method.genericParameterTypes
        //
        genericParameterTypes.forEach {
            Log.d(TAG, "type --> ${it.typeName}")
        }
        Log.d(TAG, "genericParameterTypes size ---> ${genericParameterTypes.size}")
        //获取到参数的注解值的
        var parameterAnnotations = method.parameterAnnotations
        Log.d(TAG, "parameterAnnotations size ---> ${parameterAnnotations.size}")


        proxy.method1()
        proxy.method2()

    }
}