package com.chiatai.module_java.proxy

import android.util.Log
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

/**
 * @author : zhangqi
 * @time : 12/14/20
 * desc :
 */
object ProxyUtils {


    /**
     * 通过动态代理获取到类的实例
     */
    fun <T> getProxy(service: Class<T>): T {

        /**
         * 是一个处理器当代理的实例调用了它的某一个方法就会回调invoke()方法中
         */
        var h = InvocationHandler { proxy, method, args ->
            when (method.name) {
                "method1" -> {
                    Log.d("tag", "1")
                }
                "method2" -> {
                    Log.d("tag", "2")
                }
                else -> {
                    Log.d("tag", "else")
                }
            }
        }

        return Proxy.newProxyInstance(service.classLoader, arrayOf<Class<*>>(service), h) as T
    }
}