package com.chiatai.module_kotlin_appoint.entrust

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chiatai.module_kotlin_appoint.R

class DelegateActivity : Activity() {
    private val TAG = "DelegateActivity"
    val name:String by lazy{
        Log.d(TAG,"仅仅在首次访问的时候才会执行")
        "dashingqi"
        "zhangqi"
        "dashingqi"
        "java"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delegate)

        //创建一个被委托对象
        val realPlayer = RealPlayer("大哥")
        //委托对象使用这个被委托对象
        val delegatePlayer = DelegatePlayer(realPlayer)
        delegatePlayer.match()
        delegatePlayer.upgrade()

        var product = Product()
        product.price = "${20.0}"
        Log.d(TAG, product.price)

        Log.d(TAG, "name =  $name")
        Log.d(TAG, "name =  $name")

    }
}